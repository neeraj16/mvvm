package com.example.demomvvm.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.example.demomvvm.data.repositories.UserRepository

class AuthViewModel: ViewModel() {
    var email:String? = null
    var password:String? = null
    var authListener: AuthListener? = null

    fun onLoginButtonClick() {
        authListener?.onStarted()
        if (email.isNullOrEmpty() || password.isNullOrEmpty()){
            //
            authListener?.onFailure("Email or password is empty")
            return
        }

        // success
        val loginResponse = UserRepository().userLogin(email!!, password!!)
        authListener?.onSuccess(loginResponse)

    }

}