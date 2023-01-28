package ru.my_career.my_career_api.my_career_api.flashcall

import org.springframework.stereotype.Service
import ru.my_career.my_career_api.my_career_api.common.entities.ApiResponse
import ru.my_career.my_career_api.my_career_api.flashcall.dto.AeroSmsResponseDtoData
import ru.my_career.my_career_api.my_career_api.flashcall.dto.CallDto

@Service
interface FlashcallService {
    fun call(call: CallDto): ApiResponse<AeroSmsResponseDtoData>
}