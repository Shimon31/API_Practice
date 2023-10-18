package com.example.shimon.apipractice.services

import com.example.shimon.apipractice.data.model.login.RequestLogin
import com.example.shimon.apipractice.data.model.login.ResponseLogin
import com.example.shimon.apipractice.data.model.registration.RequestRegistration
import com.example.shimon.apipractice.data.model.registration.ResponseRegistration
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {

    @POST("auth/login")
   suspend fun login(@Body requestLogin: RequestLogin) : Response<ResponseLogin>

    @POST("users/")
    suspend fun register(@Body registration: RequestRegistration) : Response<ResponseRegistration>




}