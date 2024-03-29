package ru.my_career.my_career_api.my_career_api._common.services.user_confirmation.dto

enum class CheckStatus {
    SUCCESS,
    INVALID_CODE,
    INVALID_PHONE_NUMBER,
}

data class CheckConfirmationDto(
    val status: CheckStatus
)
