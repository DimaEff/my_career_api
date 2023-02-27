package ru.my_career.my_career_api.my_career_api

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import ru.my_career.my_career_api.my_career_api.common.services.flashcall.dto.CallDto
import ru.my_career.my_career_api.my_career_api.common.services.flashcall.dto.PhoneNumberDto
import ru.my_career.my_career_api.my_career_api.common.services.user_confirmation.UserConfirmationService

@RestController
class Abc(
    @Autowired
    val userConfirmationService: UserConfirmationService
) {
    @PostMapping("/confirmation_by_flashcall")
    fun sendConfirmationByFlashcall(@RequestBody phoneNumberDto: PhoneNumberDto) = userConfirmationService.sendConfirmationByFlashcall(phoneNumberDto)

    @PostMapping("/check_confirmation")
    fun checkConfirmation(@RequestBody callDto: CallDto) = userConfirmationService.checkCode(callDto)
}