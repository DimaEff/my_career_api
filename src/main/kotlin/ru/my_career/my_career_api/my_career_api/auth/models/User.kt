package ru.my_career.my_career_api.my_career_api.auth.models

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document

@Document("users")
data class User(
    @Id
    val _id: String = ObjectId().toString(),

    val name: String,
    val surname: String,

    @Indexed(unique = true)
    val email: String,

    @Indexed(unique = true)
    val phoneNumber: String,

    val _isActive: Boolean = true,
)
