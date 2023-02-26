package ru.my_career.my_career_api.my_career_api.common.services.flashcall

import org.springframework.stereotype.Service
import ru.my_career.my_career_api.my_career_api.common.services.flashcall.dto.AeroSmsResponseDto
import ru.my_career.my_career_api.my_career_api.common.services.flashcall.dto.CallDto

@Service
interface FlashcallService {
    fun call(call: CallDto): AeroSmsResponseDto
}