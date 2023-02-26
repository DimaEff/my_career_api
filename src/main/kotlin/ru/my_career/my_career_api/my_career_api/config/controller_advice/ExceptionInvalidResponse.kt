package ru.my_career.my_career_api.my_career_api.config.controller_advice

data class ExceptionInvalidResponse(
    val message: String = "Validation failed",
    val fieldsInfo: Map<String, String?>,
)
