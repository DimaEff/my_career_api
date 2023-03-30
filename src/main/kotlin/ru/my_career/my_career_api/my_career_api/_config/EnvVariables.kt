package ru.my_career.my_career_api.my_career_api._config

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class EnvVariables {
    @Value("\${my_career.api_prefix}")
    lateinit var apiPrefix: String

    @Value("\${my_career.api_version}")
    lateinit var apiVersion: String

    @Value("\${my_career.sms_aero.url}")
    lateinit var aeroUrl: String

    @Value("\${my_career.sms_aero.email}")
    lateinit var aeroEmail: String

    @Value("\${my_career.sms_aero.api_key}")
    lateinit var aeroApiKey: String
}