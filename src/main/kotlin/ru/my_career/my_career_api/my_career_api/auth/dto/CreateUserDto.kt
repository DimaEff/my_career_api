package ru.my_career.my_career_api.my_career_api.auth.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotNull
import ru.my_career.my_career_api.my_career_api._common.services.sms_sending.dto.PhoneNumberDto
import ru.my_career.my_career_api.my_career_api._common.validators.text.ShortText

open class CreateUserDto(
    @field:ShortText
    val name: String,

    @field:ShortText
    val surname: String,

    countryName: String,
    phoneNumber: String,

    @NotNull
    @field:Email
    val email: String,
) : PhoneNumberDto(countryName, phoneNumber)
