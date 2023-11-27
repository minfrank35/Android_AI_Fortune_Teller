import android.util.Log
import android.view.MotionEvent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.text.input.KeyboardType.Companion.Text
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun BasicRadioButtonExample(selectedOption : String, onClickRadioButton1 : () -> Unit, onClickRadioButton2 : () -> Unit) {

    Row(verticalAlignment = Alignment.CenterVertically) {
        RadioButton(
            selected = selectedOption == "male",
            onClick = { onClickRadioButton1() }
        )
        Text("Male")

        RadioButton(
            selected = selectedOption == "female",
            onClick = { onClickRadioButton2() }
        )
        Text("Female")
    }
}