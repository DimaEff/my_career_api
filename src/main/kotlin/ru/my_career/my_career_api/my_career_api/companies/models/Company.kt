package ru.my_career.my_career_api.my_career_api.companies.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("companies")
data class Company(
    @Id
    val id: String,

    val title: String,
)
