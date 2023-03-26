package ru.my_career.my_career_api.my_career_api.roles.dto

import jakarta.validation.constraints.Pattern
import ru.my_career.my_career_api.my_career_api.common.validators.constants.WITHOUT_SPACES_REGEX
import ru.my_career.my_career_api.my_career_api.common.validators.title.Description
import ru.my_career.my_career_api.my_career_api.common.validators.title.Title
import ru.my_career.my_career_api.my_career_api.common.validators.value_of_enum.ValueOfEnum
import ru.my_career.my_career_api.my_career_api.roles.PermissionType

data class CreatePermissionDto(
    @field:Title
    @field:Pattern(
        regexp = WITHOUT_SPACES_REGEX,
        message = "The title must be without spaces. Please, replace the spaces with `_`"
    )
    val title: String,

    @field:ValueOfEnum(enumClass = PermissionType::class)
    val permissionType: String,

    @field:Description
    val description: String,
)
