package com.supermin.ai_fortune_teller.view.menu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.supermin.ai_fortune_teller.view.AIFortuneNavHost
import com.supermin.ai_fortune_teller.view.menu.viewmodel.HomeViewModel

class MenuActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MenuView()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MenuView() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { MenuBottomBar(navController = navController) },
    ) {
        Box(modifier = Modifier.padding(bottom = it.calculateBottomPadding())) {
            AIFortuneNavHost(navController)
        }
    }
}







