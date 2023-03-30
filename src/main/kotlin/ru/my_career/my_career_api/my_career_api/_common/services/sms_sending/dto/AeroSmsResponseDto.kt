package ru.my_career.my_career_api.my_career_api._common.services.sms_sending.dto

import kotlinx.serialization.Serializable

@Serializable
data class AeroSmsResponseDto(
    val success: Boolean,
    val data: AeroSmsResponseDtoData? = null,
    val message: String? = null
)

@Serializable
data class AeroSmsResponseDtoData(
    val id: Int,
    val from: String,
    val number: String,
    val text: String,
    val status: Int,
    val extendStatus: String,
    val channel: String,
    val dateCreate: Int,
    val dateSend: Int,
)
