package ru.my_career.my_career_api.my_career_api.auth

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import jakarta.servlet.http.Cookie
import jakarta.servlet.http.HttpServletResponse
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties.Jwt
import ru.my_career.my_career_api.my_career_api.auth.dto.JwtDataDto
import org.springframework.stereotype.Service
import ru.my_career.my_career_api.my_career_api._common.toMap
import java.util.*

@Service
class JwtServiceImpl : JwtService {
    override fun setJwtTokenInCookies(jwtData: JwtDataDto, response: HttpServletResponse) {
        val jwt = getJwt(jwtData)
        val cookie = Cookie(JWT_TOKEN_KEY, jwt)
        response.addCookie(cookie)
    }

    private fun getJwt(jwtData: JwtDataDto): String {
        return JWT.create()
            .withPayload(toMap(jwtData))
            .withExpiresAt(Date(System.currentTimeMillis() + DAY_IN_MILLIS))
            .sign(Algorithm.HMAC512("string"))
    }
}
