package ru.my_career.my_career_api.my_career_api._common.services.sms_sending.dto

import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import ru.my_career.my_career_api.my_career_api._common.validators.value_of_enum.ValueOfEnum
import ru.my_career.my_career_api.my_career_api._common.services.sms_sending.CODE_SIZE
import ru.my_career.my_career_api.my_career_api._common.services.sms_sending.CountryCode
import ru.my_career.my_career_api.my_career_api._common.services.sms_sending.PHONE_NUMBER_SIZE

open class PhoneNumberDto(
    @field:NotNull
    @field:ValueOfEnum(enumClass = CountryCode::class)
    val countryName: String,

    @field:NotNull
    @field:Size(min = PHONE_NUMBER_SIZE, max = PHONE_NUMBER_SIZE)
    val phoneNumber: String,
) {
    fun getNumberAsString(): String = "${CountryCode.valueOf(countryName).code}$phoneNumber"
}

class SmsDto(
    countryName: String,
    phoneNumber: String,

    @field:Size(min = CODE_SIZE, max = CODE_SIZE)
    val code: String,
): PhoneNumberDto(countryName, phoneNumber)
