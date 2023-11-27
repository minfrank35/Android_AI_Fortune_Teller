package com.supermin.ai_fortune_teller.view.alarm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import com.supermin.ai_fortune_teller.view.AlarmView

class AlarmActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val alarmViewModel = remember { AlarmViewModel() }

            AlarmView(alarmViewModel)
        }
    }
}

