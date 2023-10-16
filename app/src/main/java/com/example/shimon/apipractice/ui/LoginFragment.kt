package com.example.shimon.apipractice.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.shimon.apipractice.R
import com.example.shimon.apipractice.data.model.login.RequestLogin
import com.example.shimon.apipractice.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@AndroidEntryPoint
class LoginFragment : Fragment() {
    lateinit var binding: FragmentLoginBinding

    val viewModel : LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)

        viewModel.loginResponse.observe(viewLifecycleOwner){

            if (it.isSuccessful){

                findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
                binding.progressBar.visibility = View.GONE
            }

        }

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.signInBTN.setOnClickListener {

            binding.progressBar.visibility = View.VISIBLE

            val email = binding.emailET.text.toString()
            val password = binding.passwordET.text.toString()

            handleLogin("john@mail.com","changeme")

        }
    }

    private fun handleLogin(email: String, password: String) {
        val requestLogin = RequestLogin(email = email,password = password)

        viewModel.login(requestLogin)
    }


}