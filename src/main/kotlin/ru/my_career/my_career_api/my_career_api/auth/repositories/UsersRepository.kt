package ru.my_career.my_career_api.my_career_api.auth.repositories

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import ru.my_career.my_career_api.my_career_api.auth.models.User
import java.util.Optional

interface UsersRepository : MongoRepository<User, String> {
    @Query
    fun findByPhoneNumber(phoneNumber: String): Optional<User>;

    @Query
    fun findByEmail(email: String): Optional<User>;
}
