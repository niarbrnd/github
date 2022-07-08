package cib.learning.xml2rabbit.Service

import cib.learning.sbxml2sql.dto.Persons
import org.springframework.stereotype.Service
import java.io.*
import javax.xml.bind.JAXBContext
import javax.xml.bind.JAXBException
import javax.xml.bind.Marshaller
@Service
class Xml {
    @Throws(JAXBException::class, FileNotFoundException::class)
    fun getPerson(file: File): Persons {
        var pers = Persons()
        val pathtoxml=file.absolutePath
        val filexml: FileReader
        try {
            println("FileReader "+pathtoxml)
            filexml =FileReader(pathtoxml.toString())
        } catch (e: FileNotFoundException) {
            println("file xml $pathtoxml not found")
            e.printStackTrace()
            return pers
        }
        println("file read")
        try {
            val context: JAXBContext = JAXBContext.newInstance(Persons::class.java)
            pers = context.createUnmarshaller()
                .unmarshal(filexml) as Persons
            //println(per)
        } catch (e: JAXBException) {
            println("JAXB Failed")
            e.printStackTrace()
        }
        return pers
    }

    @Throws(IOException::class)
    fun exportPersontoFile(pers: Persons?, pathexport: String): Boolean {
        val filexml: FileWriter
        filexml = try {
            FileWriter(pathexport)
        } catch (e: FileNotFoundException) {
            println("file xml $pathexport not write")
            e.printStackTrace()
            return false
        }
        try {
            val context: JAXBContext = JAXBContext.newInstance(Persons::class.java)
            //Create Marshaller
            val jaxbMarshaller: Marshaller = context.createMarshaller()
            //Required formatting??
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, java.lang.Boolean.TRUE)
            jaxbMarshaller.marshal(pers, filexml)
            println("Export XML export to $pathexport")
        } catch (e: JAXBException) {
            println("Export XML Failed")
            e.printStackTrace()
        }
        return false
    }
}