package com.example.domain.usecases

import com.example.domain.R
import com.example.domain.application.App
import com.example.domain.states.ErrorState
import javax.inject.Inject

class ErrorUseCase @Inject constructor() {

    operator fun invoke(message: Int) = ErrorState(
        App.resources.getString(R.string.error_button),
        App.resources.getString(message)
    )
}