package com.supermin.ai_fortune_teller.view

import android.content.Intent
import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeCompilerApi
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontVariation
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.supermin.ai_fortune_teller.R
import com.supermin.ai_fortune_teller.ui.theme.Pink
import com.supermin.ai_fortune_teller.ui.theme.fontDarkerGrotesque
import com.supermin.ai_fortune_teller.ui.theme.fontSC
import com.supermin.ai_fortune_teller.uiState.MoreUIState
import com.supermin.ai_fortune_teller.util.dpToSp
import com.supermin.ai_fortune_teller.view.menu.viewmodel.MoreViewModel
import com.supermin.ai_fortune_teller.view.setting.SettingActivity


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewMoreView() {
    val navController = rememberNavController()
    val moreViewModel = MoreViewModel()

    MoreView(navController = navController, moreViewModel = moreViewModel)
}


@Composable
fun MoreView(
    navController: NavHostController,
    moreViewModel: MoreViewModel
) {
//    val moreUiState = moreViewModel.moreUIState.observeAsState().value
    val context = LocalContext.current

    Column {
        MoreTitle(modifier = Modifier.padding(start = 30.dp, top = 19.dp, bottom = 13.dp))

        Row(modifier = Modifier.padding(start = 30.dp, end = 48.dp)) {
            ProfileImage()
            ProfileDetail(modifier = Modifier.weight(1f),name = moreViewModel.name, email = moreViewModel.email , gender = moreViewModel.gender)
            ProfileModifyButton()
        }
        
        Spacer(modifier = Modifier.height(28.dp))

        Row(modifier = Modifier
            .height(32.dp)
            .width(354.dp)
            .align(CenterHorizontally)
            .background(color = Pink, shape = RoundedCornerShape(30.dp)),
            verticalAlignment = CenterVertically
        ) {

            BirthInfoText(modifier = Modifier.weight(1f))
            HorizontalDivideText()
            BirthInfoText(modifier = Modifier.weight(1f))
            HorizontalDivideText()
            BirthInfoText(modifier = Modifier.weight(1f))
        }
        
        Spacer(modifier = Modifier.height(27.dp))



        LazyVerticalGrid(columns = GridCells.Fixed(3), contentPadding = PaddingValues(16.dp)) {
            items(moreViewModel.moreMenuGridList) { item ->
                MoreMenuGridItem(
                    imageResourceId = item.icon,
                    title = item.title,
                    onClick = {
                        item.onClick(context)
                    }
                )
            }
        }
    }
}

@Composable
fun MoreTitle(modifier : Modifier = Modifier) {
    Row(modifier) {
        Image(
            modifier = Modifier
                .height(32.dp)
                .width(32.dp),
            painter = painterResource(id = R.drawable.cards),
            contentDescription = null
        )
        Spacer(modifier = Modifier.width(14.dp))

        Text(
            text = stringResource(id = R.string.AI_Fortune_Teller),
            fontFamily = fontDarkerGrotesque,
            fontWeight = FontWeight.Bold,
            fontSize = dpToSp(dp = 22.dp),
            color = Color.Black
        )
    }
}

@Composable
fun ProfileImage(modifier : Modifier = Modifier
    .width(99.dp)
    .height(99.dp)
    .background(color = Color.White, shape = RoundedCornerShape(20.dp))) {
    Image(
        modifier = modifier,
        painter = painterResource(id = R.drawable.cards),
        contentDescription = null
    )
}

@Composable
fun ProfileDetail(
    modifier : Modifier = Modifier,
    name : String,
    email : String,
    gender : String,
    ) {

    Column(
        modifier = modifier,
    ) {
        Text(
            text = name,
            fontFamily = fontDarkerGrotesque,
            fontWeight = FontWeight.Normal,
            fontSize = dpToSp(dp = 25.dp),
            color = Color.Black
        )
        
        Spacer(modifier = Modifier.height(2.dp))

        Text(
            text = email,
            fontFamily = fontDarkerGrotesque,
            fontWeight = FontWeight.SemiBold,
            fontSize = dpToSp(dp = 14.dp),
            color = Color.Black
        )

        Text(
            text = gender,
            fontFamily = fontDarkerGrotesque,
            fontWeight = FontWeight.SemiBold,
            fontSize = dpToSp(dp = 12.dp),
            color = Color.Black
        )
    }
}

@Composable
fun RowScope.ProfileModifyButton() {
    Box(
        modifier = Modifier
            .height(31.dp)
            .width(54.dp)
            .border(width = 1.dp, shape = RoundedCornerShape(30.dp), color = Color.Black)
            .background(color = Color.White, shape = RoundedCornerShape(30.dp))
            .align(CenterVertically)
        ,
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = stringResource(id = R.string.modify),
            fontFamily = fontSC
        )
    }
}

@Composable
fun BirthInfoText(
    modifier : Modifier = Modifier,
    text : String = stringResource(id = R.string.default_birthday)) {
    Text(
        modifier = modifier,
        text = text,
        fontFamily = fontDarkerGrotesque,
        fontWeight = FontWeight.Normal,
        fontSize = 15.sp,
        textAlign = TextAlign.Center
    )
}

@Composable
fun HorizontalDivideText(modifier : Modifier = Modifier) {
    Text(
        modifier = modifier,
        text = "|",
        fontFamily = fontDarkerGrotesque,
        fontWeight = FontWeight.Normal,
        fontSize = 15.sp,
        color = Color.Black
    )
}

@Composable
fun MoreMenuGridItem(imageResourceId : Int = R.drawable.setting, title : String = "점검중", onClick : () -> Unit) {
    Column(
        modifier = Modifier
            .height(83.dp)
            .width(83.dp)
            .background(color = Color.White, shape = RoundedCornerShape(20.dp))
            .clickable {
                onClick()
            },
        horizontalAlignment = CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .height(32.dp)
                .width(32.dp),
            painter = painterResource(id = imageResourceId),
            contentDescription = null
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = title,
            fontFamily = fontDarkerGrotesque,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            color = Color.Black
        )
    }
}