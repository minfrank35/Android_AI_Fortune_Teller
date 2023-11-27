package com.supermin.ai_fortune_teller.view.signup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val signUpViewModel = remember { SignUpViewModel() }

            SignUpView(signUpViewModel)
        }
    }
}

