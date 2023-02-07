package ru.my_career.my_career_api.my_career_api.common.validators.ValueOfEnum

import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext

class ValueOfEnumValidator : ConstraintValidator<ValueOfEnum, String?> {
    private var acceptedValues: List<String>? = null

    override fun initialize(constraintAnnotation: ValueOfEnum) {
        super.initialize(constraintAnnotation)
        acceptedValues = constraintAnnotation.enumClass.java.enumConstants.map { it.name }
    }

    override fun isValid(value: String?, context: ConstraintValidatorContext): Boolean {
        context.disableDefaultConstraintViolation()
        context.buildConstraintViolationWithTemplate("$VALUE_OF_ENUM_MESSAGE ${acceptedValues.toString()}")

        return acceptedValues?.contains(value) ?: false
    }
}