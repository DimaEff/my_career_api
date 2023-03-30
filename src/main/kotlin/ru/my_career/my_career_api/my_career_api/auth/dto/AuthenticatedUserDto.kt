package ru.my_career.my_career_api.my_career_api.auth.dto

import ru.my_career.my_career_api.my_career_api.auth.models.User

data class AuthenticatedUserDto(
    val jwtToken: String,
    val user: User,
)
