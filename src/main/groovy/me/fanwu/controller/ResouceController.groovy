package me.fanwu.controller

import org.springframework.core.io.ClassPathResource
import org.springframework.core.io.Resource
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

import static org.springframework.http.MediaType.TEXT_HTML_VALUE

/**
 *  fanwu 编写于 2017/7/20.
 */
@RestController
class ResouceController {

    @GetMapping(path = "/", produces = TEXT_HTML_VALUE)
    Resource index() {
        return new ClassPathResource("static/index.html")
    }

    @GetMapping(path = "/file")
    Resource resource(@RequestParam(value = "name", required = false) String name) {
        return new ClassPathResource("static/" + name)
    }
}
