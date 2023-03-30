package ru.my_career.my_career_api.my_career_api.auth

import jakarta.servlet.http.HttpServletResponse
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import ru.my_career.my_career_api.my_career_api._common.services.sms_sending.dto.PhoneNumberDto
import ru.my_career.my_career_api.my_career_api._common.services.sms_sending.dto.SmsDto
import ru.my_career.my_career_api.my_career_api.auth.dto.CreateUserDto
import ru.my_career.my_career_api.my_career_api.auth.models.User

@RestController
class AuthController(
    @Autowired
    val authService: AuthService
) {
    @PostMapping("/auth")
    fun auth(@Valid @RequestBody phoneNumberDto: PhoneNumberDto): ResponseEntity<Unit> =
        ResponseEntity.ok(authService.authSendCode(phoneNumberDto))

    @PostMapping("/auth/confirmation")
    fun authConfirmation(@Valid @RequestBody smsDto: SmsDto, response: HttpServletResponse): ResponseEntity<User> =
        ResponseEntity.ok(authService.authConfirmation(smsDto, response))

    @PostMapping("/register")
    fun register(@Valid @RequestBody dto: CreateUserDto, response: HttpServletResponse): ResponseEntity<User> =
        ResponseEntity.ok(authService.register(dto, response))
}