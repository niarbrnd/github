package cib.learning.sbxml2sql.dto

import java.util.*
import javax.xml.bind.annotation.*

@XmlRootElement(name = "Person")
@XmlAccessorType(XmlAccessType.FIELD)
//@Getter
data class Person(
        private var id: Int = 0,
        @field:XmlElement
        var name: String? ,
        @field:XmlElement
        var birthday: Date?,
        @XmlElementWrapper(name = "hobbies")
        @field:XmlElement(name = "hobby")
        var Hobbies: List<Hobby>?
) {constructor():this(0,"",null, null)}