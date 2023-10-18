package com.example.shimon.apipractice.ui.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shimon.apipractice.data.model.login.RequestLogin
import com.example.shimon.apipractice.data.model.login.ResponseLogin
import com.example.shimon.apipractice.data.model.registration.RequestRegistration
import com.example.shimon.apipractice.data.model.registration.ResponseRegistration
import com.example.shimon.apipractice.data.repo.AuthRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val repo: AuthRepo) : ViewModel() {

    private var _response = MutableLiveData<Response<ResponseRegistration>>()
    val registerResponse: LiveData<Response<ResponseRegistration>> = _response

    fun register(requestRegistration: RequestRegistration) {

        viewModelScope.launch {

            _response.postValue(repo.register(requestRegistration))

        }

    }

}
