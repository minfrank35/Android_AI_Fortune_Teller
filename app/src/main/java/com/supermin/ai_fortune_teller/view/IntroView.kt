package com.supermin.ai_fortune_teller.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.supermin.ai_fortune_teller.R
import com.supermin.ai_fortune_teller.viewmodel.MoreViewModel

@Preview(showBackground = true)
@Composable
fun PreviewIntroView() {
    val navController = rememberNavController()
    IntroView(navController = navController)
}
@Composable
fun IntroView(
    navController: NavHostController
) {
    Box(
        Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Column {
            Image(painter = painterResource(id = R.drawable.ai_fortune_teller_app_icon), contentDescription = null)
            Text(
                text = stringResource(id = R.string.app_name),
                color = Color.Black,
                fontSize = 40.sp,
            )
        }
    }
}