package com.internquest.trymvp.di.component

import com.internquest.trymvp.di.module.AppModule
import com.internquest.trymvp.di.scope.TryMvpApplicationScope
import com.internquest.trymvp.feature.login.LoginPresenter
import dagger.Component

@TryMvpApplicationScope
@Component(modules = [AppModule::class])
interface ApplicationComponent {

    fun inject(loginPresenter: LoginPresenter)

}