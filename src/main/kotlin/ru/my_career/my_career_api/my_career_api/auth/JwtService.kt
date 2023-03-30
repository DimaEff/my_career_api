package ru.my_career.my_career_api.my_career_api.auth

import jakarta.servlet.http.HttpServletResponse
import ru.my_career.my_career_api.my_career_api.auth.dto.JwtDataDto

interface JwtService {
    fun setJwtTokenInCookies(jwtData: JwtDataDto, response: HttpServletResponse): Unit
}