package cib.learning.sbxml2sql.dto

import lombok.Getter
import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlRootElement

@XmlRootElement(name = "Persons")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
data class Persons(
        @field:XmlElement(name = "Person")
        var People: List<Person>?=null
)
