package ru.my_career.my_career_api.my_career_api.common.services.user_confirmation

import ru.my_career.my_career_api.my_career_api.common.services.flashcall.dto.AeroSmsResponseDto
import ru.my_career.my_career_api.my_career_api.common.services.flashcall.dto.CallDto
import ru.my_career.my_career_api.my_career_api.common.services.flashcall.dto.PhoneNumberDto
import ru.my_career.my_career_api.my_career_api.common.services.user_confirmation.dto.CheckResultDto

interface UserConfirmationService {
    fun sendConfirmationByFlashcall(phoneNumberDto: PhoneNumberDto): AeroSmsResponseDto
    fun checkCode(callDto: CallDto): CheckResultDto
}