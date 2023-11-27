package com.supermin.ai_fortune_teller.view

import android.app.Activity
import android.content.Intent
import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.supermin.ai_fortune_teller.R
import com.supermin.ai_fortune_teller.ui.theme.BlueButton
import com.supermin.ai_fortune_teller.ui.theme.BlueDetail
import com.supermin.ai_fortune_teller.ui.theme.fontDancingScript
import com.supermin.ai_fortune_teller.ui.theme.fontDarkerGrotesque
import com.supermin.ai_fortune_teller.util.dpToSp
import com.supermin.ai_fortune_teller.view.comm.GeneralTextField
import com.supermin.ai_fortune_teller.view.login.LoginActivity
import com.supermin.ai_fortune_teller.view.login.LoginViewModel
import com.supermin.ai_fortune_teller.view.menu.MenuActivity
import com.supermin.ai_fortune_teller.view.signup.SignUpActivity

@Preview(showBackground = true)
@Composable
fun PreviewLoginView() {
    val loginViewModel = LoginViewModel()

    LoginView(loginViewModel)
}

@Composable
fun LoginView(
    loginViewModel: LoginViewModel
) {
    val context = LocalContext.current
    Column(
        Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(id = R.drawable.login_back),
                contentScale = ContentScale.FillBounds,
            ) ,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.padding(top = 146.dp, bottom = 32.dp),
            text = stringResource(id = R.string.login_title),
            color = Color.White,
            fontSize = dpToSp(dp = 40.dp),
            fontFamily = fontDancingScript,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        GeneralTextField(
            modifier = Modifier.padding(start = 60.dp, end = 60.dp).height(52.dp).background(Color.White, shape = RoundedCornerShape(8.dp)),
            value = loginViewModel.id,
            hint = stringResource(id = R.string.id_hint)
        ) {
            loginViewModel.id = it
        }
        
        Spacer(modifier = Modifier.height(7.dp))

        GeneralTextField(
            modifier = Modifier.padding(start = 60.dp, end = 60.dp).height(52.dp).background(Color.White, shape = RoundedCornerShape(8.dp)),
            value = loginViewModel.pwd,
            isPwd = false,
            hint = stringResource(id = R.string.pwd_hint)
        ) {
            loginViewModel.pwd = it
        }

        Spacer(modifier = Modifier.height(23.dp))

        Box(
            modifier = Modifier.padding(start = 60.dp, end = 60.dp).height(45.dp).fillMaxWidth().background(color = BlueButton, shape = RoundedCornerShape(8.dp))
                .clickable {
                   loginViewModel.callLogin {
                       val intent = Intent(context, MenuActivity::class.java)
                       context.startActivity(intent)
                   }
                },
            contentAlignment = Alignment.Center
        ) {
            Text(
                    text = stringResource(id = R.string.login),
            color = Color.White,
            fontSize = dpToSp(dp = 20.dp),
            fontFamily = fontDarkerGrotesque,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.height(51.dp))

        Row() {
            Text(
                text = stringResource(id = R.string.goto_signup_ques),
                color = Color.Black,
                fontSize = dpToSp(dp = 16.dp),
                fontFamily = fontDarkerGrotesque,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center
            )

            Text(
                modifier = Modifier.clickable {
                    val intent = Intent(context, SignUpActivity::class.java)
                    context.startActivity(intent)
                },
                text = stringResource(id = R.string.goto_signup),
                color = BlueDetail,
                fontSize = dpToSp(dp = 16.dp),
                fontFamily = fontDarkerGrotesque,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center
            )
        }

    }
}