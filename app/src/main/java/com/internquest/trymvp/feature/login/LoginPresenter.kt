package com.internquest.trymvp.feature.login

import com.internquest.trymvp.BaseApplication
import com.internquest.trymvp.data.model.body.LoginBody
import com.internquest.trymvp.data.remote.ApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class LoginPresenter(private val view: LoginView) : CoroutineScope {

    @Inject
    lateinit var apiService: ApiService

    private var loginView: LoginView? = null
    private var job: Job = Job()
    override val coroutineContext: CoroutineContext get() = Dispatchers.IO + job

    init {
        declateView()
    }

    private fun declateView() {
        loginView = view

    }

    fun login(loginBody: LoginBody) = launch(Dispatchers.Main) {
        runCatching {
            loginView?.showLoading(true)
            val resp = apiService.login(
                loginBody.userName,
                loginBody.password,
                loginBody.expireInMins
            )
        }.onSuccess {
            loginView?.showLoading(false)
            loginView?.OnLoginSuccess("Login Success")
        }.onFailure {
            loginView?.showLoading(false)
            val errorMessage= it.message ?: "Unknown Error"
            loginView?.OnLoginFailed(errorMessage)
        }
    }
}