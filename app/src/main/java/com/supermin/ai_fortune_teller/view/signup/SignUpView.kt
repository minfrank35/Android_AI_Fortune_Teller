package com.supermin.ai_fortune_teller.view.signup

import BasicRadioButtonExample
import android.content.Intent
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.supermin.ai_fortune_teller.R
import com.supermin.ai_fortune_teller.ui.theme.BlueButton
import com.supermin.ai_fortune_teller.ui.theme.fontDancingScript
import com.supermin.ai_fortune_teller.ui.theme.fontDarkerGrotesque
import com.supermin.ai_fortune_teller.view.comm.GeneralTextField
import com.supermin.ai_fortune_teller.view.menu.MenuActivity

@Preview(showBackground = true)
@Composable
fun PreviewSignUpView() {
    val signUpViewModel = SignUpViewModel()

    SignUpView(signUpViewModel)
}

@Composable
fun SignUpView(
    signUpViewModel : SignUpViewModel
) {
    val context = LocalContext.current

    Column(
        Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(id = R.drawable.login_back),
                contentScale = ContentScale.FillBounds,
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.padding(top = 110.dp, bottom = 24.dp),
            text = stringResource(id = R.string.login_title),
            color = Color.White,
            fontSize = 40.sp,
            fontFamily = fontDancingScript,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        InputGroup(
            text = stringResource(id = R.string.email_title),
            value = signUpViewModel.email,
            hint = stringResource(id = R.string.email_hint)
        ) {
            signUpViewModel.email = it
        }
        
        Spacer(modifier = Modifier.height(10.dp))

        InputGroup(
            text = stringResource(id = R.string.password_title),
            value = signUpViewModel.pwd,
            hint = stringResource(id = R.string.password_hint)
        ) {
            signUpViewModel.pwd = it
        }

        Spacer(modifier = Modifier.height(4.dp))

        GeneralTextField(
            modifier = Modifier
                .padding(start = 60.dp, end = 60.dp)
                .height(40.dp)
                .background(Color.White, shape = RoundedCornerShape(8.dp)),
            value = signUpViewModel.pwdCheck,
            hint = stringResource(id = R.string.password_check_hint)
        ) {
            signUpViewModel.pwdCheck = it
        }

        Spacer(modifier = Modifier.height(10.dp))

        InputGroup(
            text = stringResource(id = R.string.name_title),
            value = signUpViewModel.name,
            hint = stringResource(id = R.string.name_hint)
        ) {
            signUpViewModel.name = it
        }

        Spacer(modifier = Modifier.height(10.dp))

        InputGroup(
            text = stringResource(id = R.string.birthday_title),
            value = signUpViewModel.birthDay,
            hint = stringResource(id = R.string.birthday_hint)
        ) {
            signUpViewModel.birthDay = it
        }

        Spacer(modifier = Modifier.height(10.dp))

        GenderGroup(selectedOption = signUpViewModel.gender, onClickRadioButton1 = {
            signUpViewModel.gender = "male"
        }) {
            signUpViewModel.gender = "female"
        }

        Spacer(modifier = Modifier.height(12.dp))

        Box(
            modifier = Modifier
                .padding(start = 60.dp, end = 60.dp)
                .height(45.dp)
                .fillMaxWidth()
                .background(color = BlueButton, shape = RoundedCornerShape(8.dp))
                .clickable {
                    signUpViewModel.callLogin {
                        val intent = Intent(context, MenuActivity::class.java)
                        context.startActivity(intent)
                    }
                },
            contentAlignment = Alignment.Center
        ) {
            Text(
            text = stringResource(id = R.string.signup),
            color = Color.White,
            fontSize = 20.sp,
            fontFamily = fontDarkerGrotesque,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun InputGroup(
    modifier : Modifier = Modifier.padding(start = 60.dp , end = 60.dp),
    text : String,
    value : String,
    hint : String,
    onValueChange : (String) -> Unit
) {
    Column(modifier) {
        Text(
            text = text,
            color = Color.White,
            fontSize = 20.sp,
            fontFamily = fontDarkerGrotesque,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center
        )
        
        Spacer(modifier = Modifier.height(5.dp))

        GeneralTextField(
            modifier = Modifier
                .height(40.dp)
                .background(Color.White, shape = RoundedCornerShape(8.dp)),
            value = value,
            hint = hint
        ) {
            onValueChange(it)
        }
    }
}

@Composable
fun GenderGroup(
    modifier : Modifier = Modifier.padding(start = 60.dp, end = 60.dp),
    selectedOption : String,
    onClickRadioButton1 : () -> Unit,
    onClickRadioButton2 : () -> Unit
) {
    Row(modifier = modifier) {
        Text(
            modifier = Modifier.weight(1f),
            text = stringResource(id = R.string.gender_title),
            color = Color.White,
            fontSize = 20.sp,
            fontFamily = fontDarkerGrotesque,
            fontWeight = FontWeight.Medium,
        )

        BasicRadioButtonExample(selectedOption = selectedOption, onClickRadioButton1 = {
            onClickRadioButton1()
        }) {
            onClickRadioButton2()
        }
    }
}