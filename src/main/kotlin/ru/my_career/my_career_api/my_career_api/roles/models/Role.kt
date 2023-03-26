package ru.my_career.my_career_api.my_career_api.roles.models

import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document
import ru.my_career.my_career_api.my_career_api.roles.CommonRoleId

// https://github.com/DimaEff/my_career_api1/wiki/1.-%D0%9A%D0%BE%D0%BC%D0%BF%D0%B0%D0%BD%D0%B8%D0%B8.-%D0%A1%D0%BE%D1%82%D1%80%D1%83%D0%B4%D0%BD%D0%B8%D0%BA%D0%B8.-%D0%A0%D0%BE%D0%BB%D0%B8#%D1%81%D1%85%D0%B5%D0%BC%D0%B0-role@Document("roles")
@Document("roles")
data class Role(
//    @DBRef
//    val company: Company,

    val title: String,

    val description: String,

    @DBRef
    val permissions: Collection<Permission>,

    val commonRoleId: CommonRoleId?,

// TODO: mb need to add role based access to some roles
//    @DBRef
//    val haveAccessPermissions: Collection<Permission>,
)

