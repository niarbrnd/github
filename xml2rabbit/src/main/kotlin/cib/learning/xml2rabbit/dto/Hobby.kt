package cib.learning.sbxml2sql.dto

import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlRootElement

@XmlRootElement(name = "hobby")
@XmlAccessorType(XmlAccessType.FIELD)
data class Hobby(
        @field:XmlElement
        var complexity: Int,
        @field:XmlElement
        var hobby_name: String){
        constructor():this (0,"")
}
