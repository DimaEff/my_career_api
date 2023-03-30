package ru.my_career.my_career_api.my_career_api._common.validators.one_of

import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext


class OneOfValidator : ConstraintValidator<OneOf, String> {
    private var validValues: Array<String>? = null

    override fun initialize(constraintAnnotation: OneOf?) {
        super.initialize(constraintAnnotation)
        validValues = constraintAnnotation?.values
    }

    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
        return validValues?.contains(value) ?: false
    }
}