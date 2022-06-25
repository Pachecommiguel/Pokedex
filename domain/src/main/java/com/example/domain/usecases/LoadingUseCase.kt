package com.example.domain.usecases

import com.example.domain.R
import com.example.domain.application.App
import com.example.domain.states.LoadingState
import javax.inject.Inject

class LoadingUseCase @Inject constructor() {

    operator fun invoke() = LoadingState(
        App.resources.getString(R.string.loading_title),
        App.resources.getString(R.string.loading_description)
    )
}