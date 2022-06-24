package com.example.domain.usecases

import com.example.domain.states.MainState
import javax.inject.Inject

class MainUseCase @Inject constructor(

) {
    operator fun invoke() = MainState()
}