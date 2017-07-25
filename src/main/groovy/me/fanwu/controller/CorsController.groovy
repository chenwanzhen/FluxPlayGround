package me.fanwu.controller

import me.fanwu.domain.Person
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
 *  fanwu 编写于 2017/7/25.
 */
@RestController
class CorsController {

    @GetMapping("/cors/no")
    Person noCors() {
        new Person(id: "foo", lastname: "Bar", firstname: "Baz")
    }

    @GetMapping("/cors/config")
    Person corsConfig() {
        new Person(id: "foo", lastname: "Bar", firstname: "Baz")
    }

    @CrossOrigin
    @GetMapping("/cors/annotation")
    Person corsAnnotation() {
        new Person(id: "foo", lastname: "Bar", firstname: "Baz")
    }
}
