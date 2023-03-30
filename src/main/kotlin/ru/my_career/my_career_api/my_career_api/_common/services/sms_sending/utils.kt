package ru.my_career.my_career_api.my_career_api._common.services.sms_sending

import ru.my_career.my_career_api.my_career_api._common.services.sms_sending.dto.PhoneNumberDto

fun getPhoneNumberString(dto: PhoneNumberDto): String {
    val countryCode = CountryCode.valueOf(dto.countryName).code.toString()
    return "${countryCode}${dto.phoneNumber}"
}