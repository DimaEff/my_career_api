package ru.my_career.my_career_api.my_career_api.common.services.user_confirmation

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import ru.my_career.my_career_api.my_career_api.common.services.user_confirmation.models.Confirmation

@Repository
interface ConfirmationRepository: MongoRepository<Confirmation, String> {
}