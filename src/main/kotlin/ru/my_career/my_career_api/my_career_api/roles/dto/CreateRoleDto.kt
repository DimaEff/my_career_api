package ru.my_career.my_career_api.my_career_api.roles.dto

import jakarta.annotation.Nullable
import ru.my_career.my_career_api.my_career_api._common.validators.text.MediumText
import ru.my_career.my_career_api.my_career_api._common.validators.text.ShortText
import ru.my_career.my_career_api.my_career_api._common.validators.value_of_enum.ValueOfEnum
import ru.my_career.my_career_api.my_career_api.roles.CommonRoleId

data class CreateRoleDto(
//    val companyId: String,

    @field:ShortText
    val title: String,

    @field:MediumText
    val description: String,

    val permissions: Collection<String>,

    @field:Nullable
    @field:ValueOfEnum(enumClass = CommonRoleId::class)
    val commonRoleId: String?,
)
