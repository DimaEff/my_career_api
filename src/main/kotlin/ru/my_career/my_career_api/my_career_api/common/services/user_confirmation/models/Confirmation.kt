package ru.my_career.my_career_api.my_career_api.common.services.user_confirmation.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import org.springframework.stereotype.Component

//@Component
@Document("confirmation")
data class Confirmation(
    @Id
    val id: String,

    @Field(name = "code")
    val code: String,
)
