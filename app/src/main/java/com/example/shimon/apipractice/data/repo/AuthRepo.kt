package com.example.shimon.apipractice.data.repo

import com.example.shimon.apipractice.data.model.login.RequestLogin
import com.example.shimon.apipractice.data.model.login.ResponseLogin
import com.example.shimon.apipractice.data.model.registration.RequestRegistration
import com.example.shimon.apipractice.data.model.registration.ResponseRegistration
import com.example.shimon.apipractice.services.AuthService
import retrofit2.Response
import javax.inject.Inject

class AuthRepo @Inject constructor(private val service: AuthService) {

    suspend fun login(requestLogin: RequestLogin): Response<ResponseLogin> {

        return service.login(requestLogin)
    }

    suspend fun register(requestRegistration:RequestRegistration): Response<ResponseRegistration> {
        return service.register(requestRegistration)


    }

}