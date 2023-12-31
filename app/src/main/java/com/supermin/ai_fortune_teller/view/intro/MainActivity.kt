package com.supermin.ai_fortune_teller.view.intro

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.supermin.ai_fortune_teller.view.IntroView
import com.supermin.ai_fortune_teller.view.login.LoginActivity
import com.supermin.ai_fortune_teller.view.menu.MenuActivity

class MainActivity : ComponentActivity() {

    private val SPLASH_TIME_OUT: Long = 3000 // 3초

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IntroView()
        }

        Handler().postDelayed({
            // 다음 화면으로 이동할 Intent 생성
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            // 현재 액티비티 종료
            finish()
        }, SPLASH_TIME_OUT)

    }
}

