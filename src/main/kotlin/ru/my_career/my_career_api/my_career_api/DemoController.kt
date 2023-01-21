package ru.my_career.my_career_api.my_career_api

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class DemoController(
    @Value("\${my_career.api_prefix}") val apiPrefix: String,
    @Value("\${my_career.api_version}") val apiVersion: String
) {
    @GetMapping("/test")
    fun test() = "$apiPrefix/$apiVersion"
}