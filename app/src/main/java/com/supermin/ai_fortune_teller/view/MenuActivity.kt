package com.supermin.ai_fortune_teller.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.supermin.ai_fortune_teller.uiState.HomeUIState
import com.supermin.ai_fortune_teller.viewmodel.HomeViewModel
import com.supermin.ai_fortune_teller.viewmodel.MoreViewModel

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
        bottomBar = { BottomNavigationView(navController = navController) }
    ) {
        Box(Modifier.padding(it)) {
            AIFortuneNavHost()
        }
    }
}

@Composable
fun BottomNavigationView(navController: NavHostController): Unit {
    BottomNavigation() {

    }
}

/*
@Composable
fun MoreView(
    navController: NavHostController,
    loginViewModel: MoreViewModel
) {
    val loginUIState = loginViewModel.loginUIState.observeAsState().value

    when (loginUIState) {
        is HomeUIState.Loading -> {
        }

        is HomeUIState.Error -> {
        }

        is HomeUIState.Loaded -> {
        }

        is HomeUIState.Normal -> {

        }

        else -> {
            // TODO :: 에러 처리
        }
    }
}



@Composable
fun HomeView(
    navController: NavHostController,
    loginViewModel: HomeViewModel
) {
    val loginUIState = loginViewModel.loginUIState.observeAsState().value

    when (loginUIState) {
        is LoginUIState.Loading -> {
            LoginLoadingScreen()
        }

        is LoginUIState.Error -> {
            LoginErrorScreen(errMsg = (loginUIState as LoginUIState.Error).errMsg)
        }

        is LoginUIState.Loaded -> {
            loginViewModel.onClickCommListPopupItem((loginUIState as LoginUIState.Loaded).list[0])
        }

        is LoginUIState.Normal -> {
            LoginPwdScreen(
                id = loginViewModel.id,
                onIdValueChange = { loginViewModel.id = it },
                pwd = loginViewModel.pwd,
                onPwdValueChange = { loginViewModel.pwd = it }
            ) {
                //TODO :: 경리나라 로그인 로직 필요시 주석해제
//                loginViewModel.callLogin()

                //TODO :: 경리나라 로그인 로직 필요시 주석처리
                SerpNavigationActions(navController = navController).navigateToMain()
            }
        }

        LoginUIState.Loaded2 -> {
            SerpNavigationActions(navController = navController).navigateToMain()
        }

        else -> {
            LoginErrorScreen("null이 발생하였습니다.")
        }
    }
}*/
