package ru.my_career.my_career_api.my_career_api.roles

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.my_career.my_career_api.my_career_api.roles.dto.CreatePermissionDto
import ru.my_career.my_career_api.my_career_api.roles.dto.CreateRoleDto
import ru.my_career.my_career_api.my_career_api.roles.models.Permission
import ru.my_career.my_career_api.my_career_api.roles.models.Role
import ru.my_career.my_career_api.my_career_api.roles.repositories.PermissionRepository
import ru.my_career.my_career_api.my_career_api.roles.repositories.RoleRepository

@Service
class RolesServiceImpl(
    @Autowired val permissionRepository: PermissionRepository,
    @Autowired val roleRepository: RoleRepository,
) : RolesService {
    override fun createPermission(dto: CreatePermissionDto): Permission {
        val permissionTitle = getPermissionTitle(dto.title, PermissionType.valueOf(dto.permissionType))

        return permissionRepository.save(Permission(permissionTitle, dto.description))
    }

    override fun createRole(dto: CreateRoleDto): Role {
        val commonRoleId = if (dto.commonRoleId != null) CommonRoleId.valueOf(dto.commonRoleId) else null
        val permissions = permissionRepository.findAllById(dto.permissions)
        println(permissions)

        return roleRepository.insert(Role(
            title = dto.title,
            description = dto.description,
            commonRoleId = commonRoleId,
            permissions = permissions
        ))
    }
}