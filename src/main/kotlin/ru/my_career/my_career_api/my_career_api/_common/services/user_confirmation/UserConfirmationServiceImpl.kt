package ru.my_career.my_career_api.my_career_api._common.services.user_confirmation

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.my_career.my_career_api.my_career_api._common.services.sms_sending.SmsService
import ru.my_career.my_career_api.my_career_api._common.services.sms_sending.dto.AeroSmsResponseDto
import ru.my_career.my_career_api.my_career_api._common.services.sms_sending.dto.SmsDto
import ru.my_career.my_career_api.my_career_api._common.services.sms_sending.dto.PhoneNumberDto
import ru.my_career.my_career_api.my_career_api._common.services.user_confirmation.dto.CheckConfirmationDto
import ru.my_career.my_career_api.my_career_api._common.services.user_confirmation.dto.CheckStatus
import ru.my_career.my_career_api.my_career_api._common.services.user_confirmation.models.Confirmation

@Service
class UserConfirmationServiceImpl(
    @Autowired val confirmationRepository: ConfirmationRepository,
    val smsService: SmsService
) : UserConfirmationService {
    public override fun sendConfirmationBySms(phoneNumberDto: PhoneNumberDto): AeroSmsResponseDto {
        val phoneNumber = phoneNumberDto.getNumberAsString()
        val confirmationCode = generate4DigitsConfirmationCode()

        confirmationRepository.save(Confirmation(phoneNumber, confirmationCode))

        return this.smsService.sendSms(
            SmsDto(
                phoneNumberDto.countryName,
                phoneNumberDto.phoneNumber,
                confirmationCode
            )
        )
    }

    public override fun checkCode(smsDto: SmsDto): CheckConfirmationDto {
        val id = smsDto.getNumberAsString()

        val confirmationRes = findById(id)

        val status = if (confirmationRes.isEmpty) {
            CheckStatus.INVALID_PHONE_NUMBER
        } else {
            val confirmation = confirmationRes.get()
            if (confirmation.code == smsDto.code) CheckStatus.SUCCESS else CheckStatus.INVALID_CODE
        }

        if (status === CheckStatus.SUCCESS) {
            confirmationRepository.delete(confirmationRes.get())
        }

        return CheckConfirmationDto(status)
    }

    private fun findById(id: String) = confirmationRepository.findById(id)

    private fun generate4DigitsConfirmationCode(): String = ((Math.random() * 9000).toInt() + 1000).toString()
}