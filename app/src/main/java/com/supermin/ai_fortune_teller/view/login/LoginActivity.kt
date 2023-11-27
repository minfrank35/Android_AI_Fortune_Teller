package com.supermin.ai_fortune_teller.view.login

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import com.supermin.ai_fortune_teller.view.IntroView
import com.supermin.ai_fortune_teller.view.LoginView
import com.supermin.ai_fortune_teller.view.menu.MenuActivity
import com.supermin.ai_fortune_teller.view.menu.viewmodel.MoreViewModel

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel = remember { LoginViewModel() }

            LoginView(viewModel)
        }
    }
}

