package ru.my_career.my_career_api.my_career_api.companies.repositories

import org.springframework.data.mongodb.repository.MongoRepository
import ru.my_career.my_career_api.my_career_api.companies.models.Company

interface CompaniesRepository : MongoRepository<Company, String> {
}