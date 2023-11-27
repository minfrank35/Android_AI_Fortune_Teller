package com.supermin.ai_fortune_teller.view.setting

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.supermin.ai_fortune_teller.R
import com.supermin.ai_fortune_teller.ui.theme.Black_50
import com.supermin.ai_fortune_teller.ui.theme.fontSC
import com.supermin.ai_fortune_teller.util.dpToSp
import com.supermin.ai_fortune_teller.view.comm.OnlyBackTitle
import com.supermin.ai_fortune_teller.view.comm.OnlyTextTitle


@Preview(showBackground = true)
@Composable
fun PreviewSettingView() {
    val settingViewModel = SettingViewModel()

    SettingView(settingViewModel)
}

@Composable
fun SettingView(
    settingViewModel: SettingViewModel
) {
    Column {
        OnlyBackTitle()
        OnlyTextTitle(title = "설정")
        SettingContent(title = "알림", settingViewModel.settingList[0])
        SettingContent(title = "지원", settingViewModel.settingList[1])
        SettingContent(title = "계정/보안", settingViewModel.settingList[2])
    }
}

@Composable
fun SettingContent(
    title : String,
    items : List<SettingRowUiItem>
) {
    Column(Modifier.padding(top = 24.dp, start = 26.dp, end = 22.dp)) {
        Text(
            modifier = Modifier.padding(bottom = 17.dp),
            text = title,
            fontFamily = fontSC,
            fontSize = dpToSp(dp = 14.dp),
            color = Black_50,
        )

        LazyColumn(verticalArrangement = Arrangement.spacedBy(19.dp)) {
            itemsIndexed(items = items) { index, item ->
                SettingItem(
                    imageResourceId = item.imageResourceId,
                    title = item.title,
                    isButton = item.isButton,
                    onClickButton = { isClicked ->
                        item.onClickButton(isClicked)
                    }
                )
            }
        }
    }
}

@Composable
fun SettingItem(
    imageResourceId: Int,
    title: String,
    isButton: Boolean = false,
    onClickButton: (isClicked: Boolean) -> Unit = {}
) {
    var isClicked by remember { mutableStateOf(false) }

    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            modifier = Modifier
                .padding(end = 19.dp)
                .width(20.dp)
                .height(20.dp),
            painter = painterResource(id = imageResourceId),
            contentDescription = null
        )
        Text(
            modifier = Modifier.weight(1f),
            text = title,
            fontFamily = fontSC,
            fontWeight = FontWeight.Bold,
            fontSize = dpToSp(dp = 17.dp),
            color = Black,
        )
        if (isButton) {
            Image(
                modifier = Modifier
                    .width(50.dp)
                    .height(24.dp)
                    .clickable {
                        onClickButton(isClicked)
                        isClicked = !isClicked
                    },
                painter = if (!isClicked) painterResource(id = R.drawable.alarm_permission_unclicked) else painterResource(
                    id = R.drawable.alarm_permission_clicked
                ),
                contentDescription = null
            )
        }
    }
}

