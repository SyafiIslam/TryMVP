package com.internquest.trymvp.data.model.body

data class LoginBody(
    val userName: String,
    val password: String,
    val expireInMins: Int= 60
)
