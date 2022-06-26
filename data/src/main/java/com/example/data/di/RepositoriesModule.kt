package com.example.data.di

import com.example.data.repositories.PokemonRepository
import com.example.data.repositories.PokemonRepositoryImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class RepositoriesModule {

    @Singleton
    @Binds
    abstract fun bindPokemonRepository(repo: PokemonRepositoryImp): PokemonRepository
}