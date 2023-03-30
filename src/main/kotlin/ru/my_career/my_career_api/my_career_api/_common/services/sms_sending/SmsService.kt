package ru.my_career.my_career_api.my_career_api._common.services.sms_sending

import org.springframework.stereotype.Service
import ru.my_career.my_career_api.my_career_api._common.services.sms_sending.dto.AeroSmsResponseDto
import ru.my_career.my_career_api.my_career_api._common.services.sms_sending.dto.SmsDto

@Service
interface SmsService {
    fun sendSms(smsDto: SmsDto): AeroSmsResponseDto
}