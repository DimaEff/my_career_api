package ru.my_career.my_career_api.my_career_api._common.validators.one_of

import jakarta.validation.Constraint
import jakarta.validation.Payload
import jakarta.validation.ReportAsSingleViolation
import kotlin.reflect.KClass
import kotlin.annotation.Retention

@MustBeDocumented
@Constraint(validatedBy = [OneOfValidator::class])
@Retention(AnnotationRetention.RUNTIME)
@Target(
    AnnotationTarget.FIELD
)
@ReportAsSingleViolation
annotation class OneOf(
    val values: Array<String>,
    val message: String = "Value is invalid",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)
