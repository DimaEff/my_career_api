package ru.my_career.my_career_api.my_career_api.flashcall.dto

import kotlinx.serialization.Serializable

@Serializable
data class AeroSmsResponseDto(
    val success: Boolean,
    val data: AeroSmsResponseDtoData?,
    val message: String?
)

@Serializable
data class AeroSmsResponseDtoData(
    val id: Int,
    val status: Int,
    val code: String,
    val phone: String,
    val cost: String,
    val timeCreate: Long,
    val timeUpdate: Long,
)
