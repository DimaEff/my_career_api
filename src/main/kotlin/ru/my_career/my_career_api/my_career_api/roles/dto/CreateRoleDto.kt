package ru.my_career.my_career_api.my_career_api.roles.dto

import jakarta.annotation.Nullable
import ru.my_career.my_career_api.my_career_api.common.validators.title.Description
import ru.my_career.my_career_api.my_career_api.common.validators.title.Title
import ru.my_career.my_career_api.my_career_api.common.validators.value_of_enum.ValueOfEnum
import ru.my_career.my_career_api.my_career_api.roles.CommonRoleId

data class CreateRoleDto(
//    val companyId: String,

    @field:Title
    val title: String,

    @field:Description
    val description: String,

    val permissions: Collection<String>,

    @field:Nullable
    @field:ValueOfEnum(enumClass = CommonRoleId::class)
    val commonRoleId: String?,
)
