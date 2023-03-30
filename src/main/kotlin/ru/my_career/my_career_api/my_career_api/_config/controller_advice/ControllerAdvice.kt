package ru.my_career.my_career_api.my_career_api._config.controller_advice

import org.springframework.http.HttpStatus
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import ru.my_career.my_career_api.my_career_api._common.entities.ApiResponse
import ru.my_career.my_career_api.my_career_api._common.entities.ResponseStatus as ApiResponseStatus

@ControllerAdvice
class ControllerAdvice {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleInvalidRequestBody(e: MethodArgumentNotValidException): ApiResponse<ExceptionInvalidResponse> {
        val validationFieldsInfo = e.bindingResult.fieldErrors.associate { it.field to it.defaultMessage }
        return ApiResponse(ApiResponseStatus.FAILED, ExceptionInvalidResponse(fieldsInfo = validationFieldsInfo))
    }
}