package ru.my_career.my_career_api.my_career_api._common.services.user_confirmation

import ru.my_career.my_career_api.my_career_api._common.services.sms_sending.dto.AeroSmsResponseDto
import ru.my_career.my_career_api.my_career_api._common.services.sms_sending.dto.SmsDto
import ru.my_career.my_career_api.my_career_api._common.services.sms_sending.dto.PhoneNumberDto
import ru.my_career.my_career_api.my_career_api._common.services.user_confirmation.dto.CheckConfirmationDto

interface UserConfirmationService {
    fun sendConfirmationBySms(phoneNumberDto: PhoneNumberDto): AeroSmsResponseDto
    fun checkCode(smsDto: SmsDto): CheckConfirmationDto
}