package ru.my_career.my_career_api.my_career_api.roles

import ru.my_career.my_career_api.my_career_api.roles.dto.CreatePermissionDto
import ru.my_career.my_career_api.my_career_api.roles.dto.CreateRoleDto
import ru.my_career.my_career_api.my_career_api.roles.models.Permission
import ru.my_career.my_career_api.my_career_api.roles.models.Role

interface RolesService {
    fun createPermission(dto: CreatePermissionDto): Permission

    fun createRole(dto: CreateRoleDto): Role
}