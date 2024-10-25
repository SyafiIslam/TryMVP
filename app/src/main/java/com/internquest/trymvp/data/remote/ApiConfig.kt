package com.internquest.trymvp.data.remote

import com.internquest.trymvp.util.Constant
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiConfig {

    private val retrofit=
        Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    val api= retrofit.create(ApiService::class.java)
}