package ru.my_career.my_career_api.my_career_api.common.validators.value_of_enum

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
        context.buildConstraintViolationWithTemplate("The value must be one of the: ${acceptedValues.toString()}").addConstraintViolation()

        return acceptedValues?.contains(value) ?: false
    }
}