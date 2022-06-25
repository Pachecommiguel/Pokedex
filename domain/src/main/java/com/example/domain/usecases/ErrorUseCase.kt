package com.example.domain.usecases

import com.example.domain.R
import com.example.domain.application.App
import com.example.domain.states.DialogState
import javax.inject.Inject

class ErrorUseCase @Inject constructor() {

    operator fun invoke() = DialogState(
        App.resources.getString(R.string.error_title),
        App.resources.getString(R.string.error_description)
    )
}