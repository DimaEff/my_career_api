package ru.my_career.my_career_api.my_career_api.flashcall

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.my_career.my_career_api.my_career_api.common.entities.ApiResponse
import ru.my_career.my_career_api.my_career_api.common.entities.ResponseStatus
import ru.my_career.my_career_api.my_career_api.common.httpService.HttpService
import ru.my_career.my_career_api.my_career_api.common.httpService.RequestParams
import ru.my_career.my_career_api.my_career_api.config.EnvVariables
import ru.my_career.my_career_api.my_career_api.flashcall.dto.AeroSmsResponseDto
import ru.my_career.my_career_api.my_career_api.flashcall.dto.AeroSmsResponseDtoData
import ru.my_career.my_career_api.my_career_api.flashcall.dto.CallDto
import java.util.*

@Service
class FlashcallServiceImpl(
    val httpService: HttpService
) : FlashcallService {

    @Autowired
    lateinit var envVariables: EnvVariables

    override fun call(call: CallDto): ApiResponse<AeroSmsResponseDtoData> {
        val authBase64Headers = getAuthorisationHeader()
        val callQueryParams = getCallQueryParams(call)

        val aeroResponse = httpService.get(
            RequestParams(
                url = "${envVariables.aeroUrl}flashcall/send",
                headers = authBase64Headers,
                queryParams = callQueryParams,
                serializer = AeroSmsResponseDto.serializer(),
            )
        )

        val responseStatus =
            if (aeroResponse?.success == null || !aeroResponse.success) ResponseStatus.FAILED else ResponseStatus.SUCCESS

        return ApiResponse(responseStatus, aeroResponse?.data)
    }

    private fun getAuthorisationHeader(): Map<String, String> {
        val authBase64 =
            Base64.getEncoder().encodeToString("${envVariables.aeroEmail}:${envVariables.aeroApiKey}".toByteArray())

        return mapOf("Authorization" to "Basic $authBase64")
    }

    private fun getCallQueryParams(call: CallDto): Map<String, String> {
        val countryCode = CountryCode.valueOf(call.countryName).code.toString()
        println(countryCode)

        return mapOf("phone" to "${countryCode}${call.phoneNumber}", "code" to call.code)
    }
}