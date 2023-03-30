package ru.my_career.my_career_api.my_career_api.companies.models

import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.DocumentReference
import ru.my_career.my_career_api.my_career_api.roles.models.Role

@Document("company-user-roles")
data class CompanyUserRoles(
    @DocumentReference
    val companyId: String,

    @DocumentReference
    val userId: String,

    @DBRef
    val roles: Collection<Role>,
)
