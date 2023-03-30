package ru.my_career.my_career_api.my_career_api._common.validators.text

import jakarta.validation.Constraint
import jakarta.validation.Payload
import jakarta.validation.ReportAsSingleViolation
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import ru.my_career.my_career_api.my_career_api._common.validators.constants.STRING_MIN_SIZE
import ru.my_career.my_career_api.my_career_api._common.validators.constants.TITLE_MAX_SIZE
import kotlin.reflect.KClass

@NotNull
@NotBlank
@NotEmpty
@Size(min = STRING_MIN_SIZE, max = TITLE_MAX_SIZE)
@MustBeDocumented
@Constraint(validatedBy = [])
@Retention(AnnotationRetention.RUNTIME)
@Target(
    AnnotationTarget.FIELD
)
@ReportAsSingleViolation
annotation class ShortText(
    val message: String = "",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)
