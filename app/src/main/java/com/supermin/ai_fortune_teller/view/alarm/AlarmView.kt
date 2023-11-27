package com.supermin.ai_fortune_teller.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.supermin.ai_fortune_teller.R
import com.supermin.ai_fortune_teller.ui.theme.*
import com.supermin.ai_fortune_teller.util.dpToSp
import com.supermin.ai_fortune_teller.view.alarm.AlarmViewModel
import com.supermin.ai_fortune_teller.view.comm.OnlyBackTitle
import com.supermin.ai_fortune_teller.view.comm.OnlyTextTitle

@Preview(showBackground = true)
@Composable
fun PreviewAlarmView() {
    val alarmViewModel = AlarmViewModel()

    AlarmView(alarmViewModel)
}

@Composable
fun AlarmView(
    alarmViewModel: AlarmViewModel
) {
    Column {
        OnlyBackTitle()
        OnlyTextTitle(title = "알림함")
        Divider(modifier = Modifier.height(1.dp), color = Black_10)
        LazyColumn {
            items(alarmViewModel.alarmList) {
                AlarmItem(
                    isRead = it.isRead,
                    detail = it.title
                ) {

                }
                Divider(modifier = Modifier.height(1.dp), color = Black_10)
            }
        }
    }
}

@Composable
fun AlarmItem(isRead : Boolean, imageResource : Int = R.drawable.alarm, imageResourceRead: Int = R.drawable.alarm_read, detail : String, onClick : () -> Unit) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .background(color = if(!isRead) Color.White else Black_4)
        .padding(top = 22.dp, bottom = 22.dp, start = 24.dp, end = 29.dp)
        .clickable { onClick() }
    ) {
        Image(
            modifier = Modifier.padding(end = 20.dp),
            painter = if(!isRead) painterResource(id = imageResource) else painterResource(id = imageResourceRead),
            contentDescription = null
        )
        Text(
            text = detail,
            fontFamily = fontSC,
            fontWeight = FontWeight.Bold,
            color = if(!isRead) Color.Black else Black_50,
        )
    }
}


