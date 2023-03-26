package ru.my_career.my_career_api.my_career_api.roles.repositories

import org.springframework.data.mongodb.repository.MongoRepository
import ru.my_career.my_career_api.my_career_api.roles.models.Permission

interface PermissionRepository : MongoRepository<Permission, String> {
}