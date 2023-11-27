package com.supermin.ai_fortune_teller.view.menu

import androidx.compose.foundation.background
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType.Companion.Text
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.supermin.ai_fortune_teller.R
import com.supermin.ai_fortune_teller.ui.theme.White_10
import com.supermin.ai_fortune_teller.view.MenuNavigation

/**
 * 메인화면 BottomNavigation 아이템 정보
 */
sealed class BottomNavItem(
    val title: Int, val icon: Int, val screenRoute: String
) {
    object Home : BottomNavItem(R.string.home, R.drawable.home, MenuNavigation.HOME_ROUTE)
    object More : BottomNavItem(R.string.more, R.drawable.more, MenuNavigation.MORE_ROUTE)
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
                        contentDescription = null,
                        modifier = Modifier
                            .width(26.dp)
                            .height(26.dp)
                    )
                },
                label = { Text(text = stringResource(item.title), fontSize = 9.sp) },
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