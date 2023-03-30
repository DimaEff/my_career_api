package ru.my_career.my_career_api.my_career_api.auth

import jakarta.servlet.http.HttpServletResponse
import ru.my_career.my_career_api.my_career_api._common.services.sms_sending.dto.PhoneNumberDto
import ru.my_career.my_career_api.my_career_api._common.services.sms_sending.dto.SmsDto
import ru.my_career.my_career_api.my_career_api.auth.dto.CreateUserDto
import ru.my_career.my_career_api.my_career_api.auth.models.User

interface AuthService {
    fun authSendCode(phoneNumberDto: PhoneNumberDto): Unit
    fun authConfirmation(smsDto: SmsDto, response: HttpServletResponse): User
    fun authInCompany(companyId: String): User
    fun register(createUserDto: CreateUserDto, response: HttpServletResponse): User
}
