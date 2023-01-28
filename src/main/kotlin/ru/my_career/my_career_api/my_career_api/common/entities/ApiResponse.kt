package ru.my_career.my_career_api.my_career_api.common.entities

enum class ResponseStatus {
    SUCCESS,
    FAILED,
}

data class ApiResponse<T>(
    val status: ResponseStatus,
    val payload: T?
)
