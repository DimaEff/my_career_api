package ru.my_career.my_career_api.my_career_api.flashcall.dto

import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import ru.my_career.my_career_api.my_career_api.flashcall.CODE_SIZE
import ru.my_career.my_career_api.my_career_api.flashcall.PHONE_NUMBER_SIZE

data class CallDto(
    @field:NotNull
    val countryCode: Int,

    @field:Size(min = PHONE_NUMBER_SIZE, max = PHONE_NUMBER_SIZE)
    val phoneNumber: String,

    @field:Size(min = CODE_SIZE, max = CODE_SIZE)
    val code: String
)
