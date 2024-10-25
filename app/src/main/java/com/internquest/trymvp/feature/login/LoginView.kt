package com.internquest.trymvp.feature.login

interface LoginView {

    fun OnLoginSuccess(message: String)
    fun OnLoginFailed(message: String)
    fun showLoading(isLoading: Boolean)
}