package com.example.data.di

import com.example.data.application.RetrofitApp
import com.example.data.webservices.PokemonWebservice
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object WebservicesModule {

    @Singleton
    @Provides
    fun providePokemonWebservice() : PokemonWebservice = RetrofitApp.getInstance().create(
        PokemonWebservice::class.java
    )
}