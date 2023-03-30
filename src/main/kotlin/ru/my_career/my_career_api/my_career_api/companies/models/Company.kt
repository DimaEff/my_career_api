package ru.my_career.my_career_api.my_career_api.companies.models

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import java.time.OffsetDateTime

@Document("companies")
data class Company(
    @Indexed(unique = true)
    val title: String,

    @CreatedDate
    var createdAt: OffsetDateTime?,

    @LastModifiedDate
    val updatedDate: OffsetDateTime?,
)
