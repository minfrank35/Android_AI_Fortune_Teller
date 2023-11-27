package com.supermin.ai_fortune_teller.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.supermin.ai_fortune_teller.R
import com.supermin.ai_fortune_teller.util.dpToSp

@Preview(showBackground = true)
@Composable
fun PreviewIntroView() {
    IntroView()
}
@Composable
fun IntroView() {
    Box(
        Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                modifier = Modifier.width(203.dp).height(203.dp),
                painter = painterResource(id = R.drawable.round_app_icon),
                contentDescription = null
            )
            Text(
                text = stringResource(id = R.string.app_name),
                color = Color.Black,
                fontSize = dpToSp(dp = 40.dp),
                fontFamily = FontFamily(Font(R.font.crimson_pro_regular))
            )
        }
    }
}