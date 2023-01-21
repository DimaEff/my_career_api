package ru.my_career.my_career_api.my_career_api.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class EnvVariables {
    @Value("\${my_career.api_prefix}")
    lateinit var apiPrefix: String

    @Value("\${my_career.api_version}")
    lateinit var apiVersion: String
}