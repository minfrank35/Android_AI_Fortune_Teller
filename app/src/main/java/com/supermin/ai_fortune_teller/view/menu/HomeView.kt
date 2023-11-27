package com.supermin.ai_fortune_teller.view.menu

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.glide.GlideImage
import com.supermin.ai_fortune_teller.R
import com.supermin.ai_fortune_teller.ui.theme.fontDancingScript
import com.supermin.ai_fortune_teller.ui.theme.fontDarkerGrotesque
import com.supermin.ai_fortune_teller.ui.theme.fontKCC
import com.supermin.ai_fortune_teller.ui.theme.fontSC
import com.supermin.ai_fortune_teller.uiState.HomeUIState
import com.supermin.ai_fortune_teller.util.dpToSp
import com.supermin.ai_fortune_teller.view.comm.GeneralTextField
import com.supermin.ai_fortune_teller.view.menu.viewmodel.HomeViewModel

@Composable
fun HomeView(
    navController: NavHostController,
    homeViewModel: HomeViewModel
) {
    /*var showDialog by remember { mutableStateOf(false) }

    if (showDialog) {
        Dialog(
            onDismissRequest = { showDialog = false },
            DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false)
        ) {
            Box(
                contentAlignment= Center,
                modifier = Modifier
                    .size(100.dp)
                    .background(White, shape = RoundedCornerShape(8.dp))
            ) {
                CircularProgressIndicator()
            }
        }
    }*/
    val homeUIState = homeViewModel.homeUIState.observeAsState().value


    Column(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(id = R.drawable.login_back),
                contentScale = ContentScale.FillBounds,
            )
    ) {
        Text(
            modifier = Modifier
                .padding(top = 12.dp, start = 25.dp, bottom = 12.dp)
                .clickable {
                    homeViewModel.callChatgpt("오늘의 운세는?")
                },
            text = stringResource(id = R.string.home_title),
            color = Color.White,
            fontSize = dpToSp(dp = 35.dp),
            fontFamily = fontDarkerGrotesque,
            fontWeight = FontWeight.Medium,
        )

        if (homeUIState is HomeUIState.Loaded) {
            val scrollState = rememberScrollState()

            Column(
                Modifier
                    .padding(start = 24.dp, bottom = 30.dp, end = 24.dp, top = 20.dp)
                    .weight(1f)
                    .verticalScroll(scrollState)
            ) {
                HomeContentItem(cardNumber = "1",cardTypeTitle = "과거 카드", cardName = homeUIState.pastCardItem.cardName, imageUrl = homeUIState.pastCardItem.imageUrl, cardDetail = homeUIState.pastCardItem.cardMeaning)
                Spacer(modifier = Modifier.height(27.dp))
                HomeContentItem(cardNumber = "2",cardTypeTitle = "현재 카드", cardName = homeUIState.presentCardItem.cardName, imageUrl = homeUIState.presentCardItem.imageUrl, cardDetail = homeUIState.presentCardItem.cardMeaning)
                Spacer(modifier = Modifier.height(27.dp))
                HomeContentItem(cardNumber = "3",cardTypeTitle = "미래 카드", cardName = homeUIState.futureCardItem.cardName, imageUrl = homeUIState.futureCardItem.imageUrl, cardDetail = homeUIState.futureCardItem.cardMeaning)
                Spacer(modifier = Modifier.height(27.dp))
                Text(
                    text = "4. 결론",
                    color = Color.White,
                    fontSize = dpToSp(dp = 20.dp),
                    fontFamily = fontKCC,
                )
                Spacer(modifier = Modifier.height(11.dp))
                Text(
                    text = homeUIState.result,
                    color = Color.White,
                    fontSize = dpToSp(dp = 20.dp),
                    fontFamily = fontKCC,
                )
            }
        } else if (homeUIState is HomeUIState.Normal) {
            Box(Modifier.weight(1f)) {

            }
        } else if (homeUIState is HomeUIState.Loading){
            Box(Modifier.weight(1f)) {
                CircularProgressIndicator()
            }
        }


        Row(
            modifier = Modifier.padding(start = 24.dp, bottom = 30.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            GeneralTextField(
                modifier = Modifier
                    .height(40.dp)
                    .background(Color.White, shape = RoundedCornerShape(8.dp))
                    .weight(1f),
                hint = stringResource(id = R.string.home_hint),
                value = homeViewModel.question,
                onValueChange = {
                    homeViewModel.question = it
                }
            )

            Image(
                painter = painterResource(id = R.drawable.input_button),
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 9.dp, end = 21.dp)
                    .width(35.dp)
                    .height(35.dp)
                    .clickable {
                        homeViewModel.callChatgpt(homeViewModel.question)
                    }
            )
        }
    }



}

@Composable
fun HomeContentItem(cardNumber : String, cardTypeTitle : String,cardName : String, imageUrl : String, cardDetail : String) {
    Column() {
        Text(
            text = "$cardNumber. $cardTypeTitle : ${cardName}",
            color = Color.White,
            fontSize = dpToSp(dp = 20.dp),
            fontFamily = fontKCC,
        )
        GlideImage(
            modifier = Modifier.padding(top = 11.dp, bottom = 16.dp),
            imageModel = imageUrl,
            // Crop, Fit, Inside, FillHeight, FillWidth, None
            contentScale = ContentScale.Crop,
            // shows an image with a circular revealed animation.
            circularReveal = CircularReveal(duration = 250),
            // shows a placeholder ImageBitmap when loading.
            placeHolder = ImageBitmap.imageResource(R.drawable.back_arrow),
            // shows an error ImageBitmap when the request failed.
            error = ImageBitmap.imageResource(R.drawable.trash)
        )
        Text(
            text = cardDetail,
            color = Color.White,
            fontSize = dpToSp(dp = 20.dp),
            fontFamily = fontKCC,
        )
    }
}


@Deprecated("Use Chat")
@Composable
fun HomeContentItemDeprecated(title: String, name: String, detail: String) {
    Column {
        Text(
            modifier = Modifier.padding(bottom = 15.dp),
            text = title,
            fontFamily = fontDarkerGrotesque,
            fontWeight = FontWeight.Normal,
            fontSize = dpToSp(dp = 35.dp),
            color = Color.White
        )

        Column(
            modifier = Modifier
                .wrapContentHeight()
                .width(360.dp)
                .background(Color.White, shape = RoundedCornerShape(20.dp))
                .padding(start = 21.dp, top = 13.dp, end = 21.dp, bottom = 15.dp)
        ) {
            Text(
                modifier = Modifier.padding(bottom = 20.dp),
                text = name + "님,",
                fontFamily = fontSC,
                fontWeight = FontWeight.Bold,
                fontSize = dpToSp(dp = 24.dp),
                color = Color.Black
            )

            Text(
                modifier = Modifier
                    .width(300.dp)
                    .padding(bottom = 14.dp),
                text = detail,
                fontFamily = fontSC,
                fontWeight = FontWeight.Bold,
                fontSize = dpToSp(dp = 24.dp),
                color = Color.Black
            )

            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = stringResource(id = R.string.show_detail),
                fontFamily = fontSC,
                fontWeight = FontWeight.Bold,
                fontSize = dpToSp(dp = 13.dp),
                color = Color.Black
            )
        }
    }
}