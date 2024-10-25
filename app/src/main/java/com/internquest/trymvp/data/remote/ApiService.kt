package com.internquest.trymvp.data.remote

import com.internquest.trymvp.data.model.response.LoginResponse
import retrofit2.Response
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {

    @FormUrlEncoded
    @POST("auth/login")
    fun login(
        username: String,
        password: String,
        expireInMins: Int= 60
    ): Response<LoginResponse>
}