package ru.my_career.my_career_api.my_career_api.common.services.sms_sending

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.my_career.my_career_api.my_career_api.common.services.http.HttpService
import ru.my_career.my_career_api.my_career_api.common.services.http.RequestParams
import ru.my_career.my_career_api.my_career_api.config.EnvVariables
import ru.my_career.my_career_api.my_career_api.common.services.sms_sending.dto.AeroSmsResponseDto
import ru.my_career.my_career_api.my_career_api.common.services.sms_sending.dto.SmsDto
import java.util.*

@Service
class SmsServiceImpl(
    val httpService: HttpService
) : SmsService {

    @Autowired
    lateinit var envVariables: EnvVariables

    override fun sendSms(smsDto: SmsDto): AeroSmsResponseDto {
        val authBase64Headers = getAuthorisationHeader()
        val callQueryParams = getSmsQueryParams(smsDto)

        return httpService.get(
            RequestParams(
                url = "${envVariables.aeroUrl}sms/send",
                headers = authBase64Headers,
                queryParams = callQueryParams,
                serializer = AeroSmsResponseDto.serializer(),
            )
        ) ?: AeroSmsResponseDto(success = false, message = "Failure sms sending")
    }

    private fun getAuthorisationHeader(): Map<String, String> {
        val authBase64 =
            Base64.getEncoder().encodeToString("${envVariables.aeroEmail}:${envVariables.aeroApiKey}".toByteArray())

        return mapOf("Authorization" to "Basic $authBase64")
    }

    private fun getSmsQueryParams(smsDto: SmsDto): Map<String, String> {
        val countryCode = CountryCode.valueOf(smsDto.countryName).code.toString()
        println(countryCode)

        return mapOf(
            "number" to "${countryCode}${smsDto.phoneNumber}",
            "text" to getTemplateConfirmationCodeMessage(smsDto.code),
            "sign" to DEFAULT_CODE_SENDER
        )
    }
}