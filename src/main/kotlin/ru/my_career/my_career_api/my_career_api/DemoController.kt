package ru.my_career.my_career_api.my_career_api

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import ru.my_career.my_career_api.my_career_api.config.EnvVariables

@RestController
class DemoController {
    @Autowired
    lateinit var envVariables: EnvVariables

    @GetMapping("/test")
    fun test() = "${envVariables.apiPrefix}/${envVariables.apiVersion}"
}