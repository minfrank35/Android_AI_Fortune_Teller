package com.supermin.ai_fortune_teller.view.comm

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalTextInputService
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.supermin.ai_fortune_teller.R
import com.supermin.ai_fortune_teller.ui.theme.Black70
import com.supermin.ai_fortune_teller.ui.theme.Black_50
import com.supermin.ai_fortune_teller.ui.theme.fontDarkerGrotesque
import com.supermin.ai_fortune_teller.util.dpToSp

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun GeneralTextField(
    modifier : Modifier = Modifier.height(52.dp).background(Color.White, shape = RoundedCornerShape(8.dp)),
    value: String,
    hint: String,
    isPwd : Boolean = false,
    onValueChange : (String) -> Unit
) {
    val focusManager = LocalFocusManager.current
    Row(
        modifier = modifier
    ) {
        BasicTextField(
            value = value,
            onValueChange = { onValueChange(it) },
            modifier = Modifier
                .weight(1f)
                .padding(start = 15.dp)
                .align(CenterVertically)
            ,
            textStyle = TextStyle(
                color = Color.Black,
                fontSize = dpToSp(dp = 15.dp),
                fontFamily = fontDarkerGrotesque,
                fontWeight = FontWeight.Normal
            ),
            enabled = true,
            singleLine = true,
        ) { innerTextField ->
            TextFieldDefaults.TextFieldDecorationBox(
                value = value,
                placeholder = {
                    Text(
                        text = hint,
                        fontSize = dpToSp(dp = 15.dp),
                        fontFamily = fontDarkerGrotesque,
                        color = Black_50,
                    )
                },
                enabled = true,
                interactionSource = MutableInteractionSource(),
                visualTransformation = if(isPwd) PasswordVisualTransformation() else VisualTransformation.None,
                innerTextField = innerTextField,
                singleLine = true,
                contentPadding = PaddingValues(
                    top = 0.dp,
                    bottom = 0.dp,
                    end = 0.dp
                ), // this is how you can remove the padding,
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Black70,
                    backgroundColor = Color.White,
                ),

                )
            }

        /*if(value.value.isNotEmpty()) {
            Image(
                painter = painterResource(id = R.drawable.edittext_cancel_button),
                contentDescription = null,
                modifier = Modifier
                    .clickable(
                        indication = null,
                        interactionSource = MutableInteractionSource()
                    ) {
                        value.value = ""
                    }
                    .padding(15.dp)
            )
        }*/
    }
}