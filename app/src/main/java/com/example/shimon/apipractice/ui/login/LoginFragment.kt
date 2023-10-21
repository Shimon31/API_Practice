package com.example.shimon.apipractice.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.shimon.apipractice.R
import com.example.shimon.apipractice.base.BaseFragment
import com.example.shimon.apipractice.data.model.login.RequestLogin
import com.example.shimon.apipractice.databinding.FragmentLoginBinding
import com.example.shimon.apipractice.utils.PrefManager
import com.example.shimon.apipractice.utils.keys
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {

 val viewModel : LoginViewModel by viewModels()

    @Inject
    lateinit var prefManager: PrefManager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.loginResponse.observe(viewLifecycleOwner){

            if (it.isSuccessful){

                prefManager.setPref(keys.ACCESS_TOKEN, it.body()?.accessToken!!)
                prefManager.setPref(keys.REFRESH_TOKEN,it.body()?.refreshToken!!)

                findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
                binding.progressBar.visibility = View.GONE
            }

        }

        binding.signInBTN.setOnClickListener {

            binding.progressBar.visibility = View.VISIBLE

            val email = binding.emailET.text.toString()
            val password = binding.passwordET.text.toString()

            handleLogin("john@mail.com","changeme")

        }

        binding.RegisterBTN.setOnClickListener {

            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)

        }

    }

    private fun handleLogin(email: String, password: String) {
        val requestLogin = RequestLogin(email = email,password = password)

        viewModel.login(requestLogin)
    }


}