package com.example.shimon.apipractice.ui.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.shimon.apipractice.R
import com.example.shimon.apipractice.base.BaseFragment
import com.example.shimon.apipractice.data.model.registration.RequestRegistration
import com.example.shimon.apipractice.databinding.FragmentRegisterBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : BaseFragment<FragmentRegisterBinding>(FragmentRegisterBinding::inflate) {

    private val viewModel: RegisterViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.registerResponse.observe(viewLifecycleOwner){

            if (it.isSuccessful){

                findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
            }

        }

        binding.registerBTN.setOnClickListener {

            val name = binding.username.text.toString()
            val email = binding.emailET.text.toString().trim()
            val password = binding.password.text.toString().trim()
            val avatar =
                "https://media.licdn.com/dms/image/D5603AQGH60d71R0hLQ/profile-displayphoto-shrink_800_800/0/1678309866483?e=2147483647&v=beta&t=4KvXRvBeboFKRexi8vG6rZ-dduo6rwzkBT2wiCf2hU0"

            val requestRegistration = RequestRegistration(
                avatar = avatar,
                email = email,
                name = name,
                password = password
            )
            viewModel.register(requestRegistration)

        }


    }

}