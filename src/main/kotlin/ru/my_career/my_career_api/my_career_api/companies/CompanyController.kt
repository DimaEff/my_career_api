package ru.my_career.my_career_api.my_career_api.companies

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/companies"])
class CompanyController {
    @PostMapping
    fun createCompany() = "Company"
}