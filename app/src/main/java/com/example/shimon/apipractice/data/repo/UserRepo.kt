package com.example.shimon.apipractice.data.repo

import com.example.shimon.apipractice.data.model.login.RequestLogin
import com.example.shimon.apipractice.data.model.login.ResponseLogin
import com.example.shimon.apipractice.data.model.profile.ResponseProfile
import com.example.shimon.apipractice.data.model.registration.RequestRegistration
import com.example.shimon.apipractice.data.model.registration.ResponseRegistration
import com.example.shimon.apipractice.services.AuthService
import retrofit2.Response
import javax.inject.Inject

class UserRepo @Inject constructor(private val service: UserRepo) {



    suspend fun profile(): Response<ResponseProfile> {
        return service.profile()


    }

}