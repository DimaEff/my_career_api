package ru.my_career.my_career_api.my_career_api

import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import ru.my_career.my_career_api.my_career_api.common.services.sms_sending.dto.SmsDto
import ru.my_career.my_career_api.my_career_api.common.services.sms_sending.dto.PhoneNumberDto
import ru.my_career.my_career_api.my_career_api.common.services.user_confirmation.UserConfirmationService

@RestController
class Abc(
    @Autowired
    val userConfirmationService: UserConfirmationService
) {
    @GetMapping("/say_hi")
    fun sayHi(): String = "Hi!"

    @PostMapping("/confirmation_by_sms")
    fun sendConfirmationByFlashcall(@Valid @RequestBody phoneNumberDto: PhoneNumberDto) = userConfirmationService.sendConfirmationByFlashcall(phoneNumberDto)

    @PostMapping("/check_confirmation")
    fun checkConfirmation(@Valid @RequestBody smsDto: SmsDto) = userConfirmationService.checkCode(smsDto)
}