package ru.my_career.my_career_api.my_career_api.common.validators.ValueOfEnum

import jakarta.validation.Constraint
import jakarta.validation.Payload
import kotlin.reflect.KClass

const val VALUE_OF_ENUM_MESSAGE = "The value must be one of the enum`s values:"

@Target(
    AnnotationTarget.FIELD,
)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Constraint(validatedBy = [ValueOfEnumValidator::class])
annotation class ValueOfEnum(
    val enumClass: KClass<out Enum<*>>,
    val message: String = VALUE_OF_ENUM_MESSAGE,
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)
