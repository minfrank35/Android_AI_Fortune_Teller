package com.supermin.ai_fortune_teller.view
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.supermin.ai_fortune_teller.viewmodel.HomeViewModel
import com.supermin.ai_fortune_teller.viewmodel.MoreViewModel


class MenuNavigation {
    companion object {
        const val HOME_ROUTE = "HOME_ROUTE"
        const val INTRO_ROUTE = "INTRO_ROUTE"
        const val MORE_ROUTE = "MORE_ROUTE"
    }
}



/**
 * Models the navigation actions in the app.
 */
class AIFortuneNavigationActions(navController: NavHostController) {
    val navigateToMore: () -> Unit = {
        navController.navigate(MenuNavigation.MORE_ROUTE) {
            popUpTo(MenuNavigation.MORE_ROUTE) {
                inclusive = true
            }
            launchSingleTop = true
        }
    }

    val navigateToHome: () -> Unit = {
        navController.navigate(MenuNavigation.HOME_ROUTE) {
            popUpTo(MenuNavigation.HOME_ROUTE) {
                inclusive = true
            }
            launchSingleTop = true
        }
    }

}

@Composable
fun AIFortuneNavHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = MenuNavigation.HOME_ROUTE) {
        //메뉴 로직
        MenuComposables(navController)

    }
}
fun NavGraphBuilder.MenuComposables(navController: NavHostController) {
    composable(MenuNavigation.HOME_ROUTE) {
        val viewModel = remember { HomeViewModel() }

        HomeView(navController = navController, viewModel)
    }

    composable(MenuNavigation.MORE_ROUTE) {
        val viewModel = remember { MoreViewModel() }

        MoreView(navController = navController, viewModel)
    }
}


