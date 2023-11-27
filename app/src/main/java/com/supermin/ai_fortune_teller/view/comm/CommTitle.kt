package com.supermin.ai_fortune_teller.view.comm

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.supermin.ai_fortune_teller.R
import com.supermin.ai_fortune_teller.ui.theme.fontSC
import com.supermin.ai_fortune_teller.util.dpToSp

@Composable
fun OnlyBackTitle() {
    Row(modifier = Modifier.fillMaxWidth()) {
        Image(
            modifier = Modifier
                .padding(start = 24.dp, top = 23.dp)
                .width(23.dp)
                .height(15.dp),
            painter = painterResource(id = R.drawable.back_arrow),
            contentDescription = null
        )
    }
}

@Composable
fun OnlyTextTitle(title : String) {
    Row(modifier = Modifier.fillMaxWidth().padding(top = 26.dp, start = 24.dp)) {
        Text(
            text = title,
            fontFamily = fontSC,
            fontSize = dpToSp(dp = 30.dp),
            fontWeight = FontWeight.ExtraBold,
            color = Color.Black
        )
    }
}