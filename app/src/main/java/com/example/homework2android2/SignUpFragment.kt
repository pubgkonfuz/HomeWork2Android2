package com.example.homework2android2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.findNavController
import com.example.homework2android2.databinding.FragmentSignUpBinding

class SignUpFragment : Fragment() {
    private var _binding: FragmentSignUpBinding? = null
    private val binding: FragmentSignUpBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val preferenceHelper = PreferenceHelper(requireContext())
        goClick(preferenceHelper)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun goClick(preferenceHelper: PreferenceHelper) = with(binding) {
        btnComeIn.setOnClickListener{
            preferenceHelper.text = etUserName.text.toString().trim()
            preferenceHelper.email = etEmail.text.toString().trim()
            preferenceHelper.password = etPassword.text.toString().trim()
            findNavController().navigate(R.id.action_signUpFragment_to_homeFragment)
        }
    }

}