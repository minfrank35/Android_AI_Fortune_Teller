package com.supermin.ai_fortune_teller.view

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.supermin.ai_fortune_teller.R

/**
 * 메인화면 BottomNavigation 아이템 정보
 */
sealed class BottomNavItem(
    val title: String, val icon: Int, val screenRoute: String
) {
    object Home : BottomNavItem("Home", R.drawable.ic_launcher_background, MenuNavigation.HOME_ROUTE)
    object More : BottomNavItem("More", R.drawable.ic_launcher_background, MenuNavigation.MORE_ROUTE)
}

val BottomNavItemList = listOf<BottomNavItem>(
    BottomNavItem.Home,
    BottomNavItem.More
)

@Composable
fun MenuBottomBar(navController : NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    BottomNavigation(backgroundColor = Color.White) {
        for(item in BottomNavItemList) {
            BottomNavigationItem(
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = item.title,
                        modifier = Modifier
                            .width(26.dp)
                            .height(26.dp)
                    )
                },
                label = { Text(item.title, fontSize = 9.sp) },
                selected = currentRoute == item.screenRoute,
                onClick = {
                    navController.navigate(item.screenRoute) {
                        popUpTo(MenuNavigation.HOME_ROUTE) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}