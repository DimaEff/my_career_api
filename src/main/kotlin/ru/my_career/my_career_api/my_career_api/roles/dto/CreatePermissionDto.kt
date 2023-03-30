package ru.my_career.my_career_api.my_career_api.roles.dto

import jakarta.validation.constraints.Pattern
import ru.my_career.my_career_api.my_career_api._common.validators.constants.WITHOUT_SPACES_REGEX
import ru.my_career.my_career_api.my_career_api._common.validators.text.MediumText
import ru.my_career.my_career_api.my_career_api._common.validators.text.ShortText
import ru.my_career.my_career_api.my_career_api._common.validators.value_of_enum.ValueOfEnum
import ru.my_career.my_career_api.my_career_api.roles.PermissionType

data class CreatePermissionDto(
    @field:ShortText
    @field:Pattern(
        regexp = WITHOUT_SPACES_REGEX,
        message = "The title must be without spaces. Please, replace the spaces with `_`"
    )
    val title: String,

    @field:ValueOfEnum(enumClass = PermissionType::class)
    val permissionType: String,

    @field:MediumText
    val description: String,
)
