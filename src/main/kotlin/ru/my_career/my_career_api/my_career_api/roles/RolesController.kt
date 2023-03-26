package ru.my_career.my_career_api.my_career_api.roles

import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.my_career.my_career_api.my_career_api.common.entities.ApiResponse
import ru.my_career.my_career_api.my_career_api.common.entities.ResponseStatus
import ru.my_career.my_career_api.my_career_api.roles.dto.CreatePermissionDto
import ru.my_career.my_career_api.my_career_api.roles.dto.CreateRoleDto
import ru.my_career.my_career_api.my_career_api.roles.models.Permission
import ru.my_career.my_career_api.my_career_api.roles.models.Role

@RestController
@RequestMapping(value = ["/roles"])
class RolesController(
    @Autowired
    val rolesService: RolesService
) {
    @PostMapping("/permission")
    fun createPermission(@Valid @RequestBody dto: CreatePermissionDto): ApiResponse<Permission> {
        val permission = rolesService.createPermission(dto)
        return ApiResponse(ResponseStatus.SUCCESS, permission)
    }

    @PostMapping()
    fun createRole(@Valid @RequestBody dto: CreateRoleDto): ApiResponse<Role> {
        val role = rolesService.createRole(dto)
        return ApiResponse(ResponseStatus.SUCCESS, role)
    }
}