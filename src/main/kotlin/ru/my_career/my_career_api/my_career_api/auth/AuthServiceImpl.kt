package ru.my_career.my_career_api.my_career_api.auth

import jakarta.servlet.http.HttpServletResponse
import org.springframework.stereotype.Service
import ru.my_career.my_career_api.my_career_api._common.services.sms_sending.SmsService
import ru.my_career.my_career_api.my_career_api._common.services.sms_sending.dto.PhoneNumberDto
import ru.my_career.my_career_api.my_career_api._common.services.sms_sending.dto.SmsDto
import ru.my_career.my_career_api.my_career_api._common.services.sms_sending.getPhoneNumberString
import ru.my_career.my_career_api.my_career_api._common.services.user_confirmation.UserConfirmationService
import ru.my_career.my_career_api.my_career_api._common.services.user_confirmation.dto.CheckConfirmationDto
import ru.my_career.my_career_api.my_career_api._common.services.user_confirmation.dto.CheckStatus
import ru.my_career.my_career_api.my_career_api.auth.dto.AuthenticatedUserDto
import ru.my_career.my_career_api.my_career_api.auth.dto.CreateUserDto
import ru.my_career.my_career_api.my_career_api.auth.dto.JwtDataDto
import ru.my_career.my_career_api.my_career_api.auth.models.User
import ru.my_career.my_career_api.my_career_api.auth.repositories.UsersRepository
import java.util.Optional

@Service
class AuthServiceImpl(
    private val usersRepository: UsersRepository,
    private val jwtService: JwtService,
    private val confirmationService: UserConfirmationService,
) : AuthService {
    override fun authSendCode(phoneNumberDto: PhoneNumberDto) {
        val user = usersRepository.findByPhoneNumber(getPhoneNumberString(phoneNumberDto))

        if (user.isEmpty) {
            TODO("Implement handling if user doesnt exists")
        }

        confirmationService.sendConfirmationBySms(phoneNumberDto)
    }

    override fun authConfirmation(smsDto: SmsDto, response: HttpServletResponse): User {
        if (confirmationService.checkCode(smsDto).status !== CheckStatus.SUCCESS) {
            TODO("Implement auth confirmation failed")
        }

        val user = usersRepository.findByPhoneNumber(getPhoneNumberString(smsDto)).get()
        jwtService.setJwtTokenInCookies(JwtDataDto(user._id), response)

        return user
    }

    override fun authInCompany(companyId: String): User {
        TODO("Not yet implemented")
    }

    override fun register(createUserDto: CreateUserDto, response: HttpServletResponse): User {
        val user = createUser(createUserDto)
        jwtService.setJwtTokenInCookies(JwtDataDto(user._id), response)

        return user
    }

    private fun createUser(dto: CreateUserDto): User {
        val phoneNumber = getPhoneNumberString(dto)

        if (checkIsUserExistsByPhoneNumber(phoneNumber)) TODO("Handling if user exists")
        if (checkIsUserExistsByEmail(dto.email)) TODO("Handling if user exists")

        return usersRepository.save(User(
            name = dto.name,
            surname = dto.surname,
            email = dto.email,
            phoneNumber = phoneNumber,
        ))
    }

    private fun checkIsUserExistsByPhoneNumber(phoneNumber: String): Boolean =
        !usersRepository.findByPhoneNumber(phoneNumber).isEmpty

    private fun checkIsUserExistsByEmail(email: String): Boolean =
        !usersRepository.findByPhoneNumber(email).isEmpty
}