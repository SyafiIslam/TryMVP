package com.internquest.trymvp

import android.app.Application
import android.support.multidex.MultiDexApplication
import com.internquest.trymvp.di.component.ApplicationComponent
import com.internquest.trymvp.di.component.DaggerApplicationComponent
import com.internquest.trymvp.di.module.AppModule
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BaseApplication: MultiDexApplication() {

    companion object {
        lateinit var applicationComponent: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.builder()
            .appModule(AppModule)
            .build()

    }
}