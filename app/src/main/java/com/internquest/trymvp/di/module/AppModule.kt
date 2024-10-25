package com.internquest.trymvp.di.module

import com.internquest.trymvp.data.remote.ApiConfig
import com.internquest.trymvp.data.remote.ApiService
import com.internquest.trymvp.di.scope.TryMvpApplicationScope
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @TryMvpApplicationScope
    fun provideApiService(): ApiService = ApiConfig.api
}