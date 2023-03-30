package ru.my_career.my_career_api.my_career_api.auth.dto

data class JwtDataDto(
    val userId: String,
    val companyId: String? = null,
    val permissions: List<String>? = null,
)