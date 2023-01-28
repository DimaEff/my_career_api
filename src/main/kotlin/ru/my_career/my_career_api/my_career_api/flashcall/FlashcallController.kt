package ru.my_career.my_career_api.my_career_api.flashcall

import jakarta.validation.Valid
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.my_career.my_career_api.my_career_api.common.entities.ApiResponse
import ru.my_career.my_career_api.my_career_api.flashcall.dto.AeroSmsResponseDtoData
import ru.my_career.my_career_api.my_career_api.flashcall.dto.CallDto

@RestController
@RequestMapping(value = ["flashcall"])
class FlashcallController(
    val flashcallService: FlashcallService,
) {
    @PostMapping
    fun call(@Valid @RequestBody call: CallDto): ApiResponse<AeroSmsResponseDtoData> {
        return flashcallService.call(call)
    }
}