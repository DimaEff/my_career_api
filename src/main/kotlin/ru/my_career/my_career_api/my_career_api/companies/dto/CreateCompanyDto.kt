package ru.my_career.my_career_api.my_career_api.companies.dto

import ru.my_career.my_career_api.my_career_api._common.validators.text.ShortText

data class CreateCompanyDto(
    @field:ShortText
    val title: String
)