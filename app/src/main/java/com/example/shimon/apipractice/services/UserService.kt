package com.example.shimon.apipractice.services

import com.example.shimon.apipractice.data.model.login.RequestLogin
import com.example.shimon.apipractice.data.model.login.ResponseLogin
import com.example.shimon.apipractice.data.model.profile.ResponseProfile
import com.example.shimon.apipractice.data.model.registration.RequestRegistration
import com.example.shimon.apipractice.data.model.registration.ResponseRegistration
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface UserService {
    @POST("auth/profile")
    suspend fun profile() : Response<ResponseProfile>




}