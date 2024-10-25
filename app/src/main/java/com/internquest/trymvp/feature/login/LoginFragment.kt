package com.internquest.trymvp.feature.login

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.internquest.trymvp.R
import com.internquest.trymvp.data.model.body.LoginBody
import com.internquest.trymvp.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment(), View.OnClickListener, LoginView {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private var loginPresenter: LoginPresenter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btnLogin.setOnClickListener(this)
        setUpPresenter()
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btn_login -> {
                if (isLoginFormValid()) {
                    val username= binding.etUsername.text?.trim()
                    val password= binding.etPassword.text?.trim()
                    val expireInMins= 30

                    val loginBody= LoginBody(username.toString(), password.toString(), expireInMins)
                    loginPresenter?.login(loginBody)
                }
            }
        }
    }

    private fun isLoginFormValid(): Boolean {

        if (binding.etUsername.text.isNullOrEmpty()) {
            binding.etUsername.error = getString(R.string.txt_error_field_required)
            return false
        }

        if (binding.etPassword.text.isNullOrEmpty()) {
            binding.etPassword.error = getString(R.string.txt_error_field_required)
            return false
        }

        return true
    }

    override fun OnLoginSuccess(message: String) {
        view?.findNavController()?.navigate(R.id.action_loginFragment_to_homeFragment)
    }

    override fun OnLoginFailed(message: String) {
        Log.i("huhu", "OnLoginFailed: $message")
    }

    override fun showLoading(isLoading: Boolean) {
        if (isLoading)
            binding.loading.visibility= View.VISIBLE
        else
            binding.loading.visibility= View.GONE
    }

    fun setUpPresenter() {
        loginPresenter= LoginPresenter(this)
    }

    private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}