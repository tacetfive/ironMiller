package com.github.tacetfive.ironmiller.core.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.github.tacetfive.ironmiller.R
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.foundation.layout.width
import com.github.tacetfive.ironmiller.core.ui.theme.IronMillerTheme
import androidx.compose.ui.Alignment // wrong: import android.text.Layout.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.runtime.*

@Composable
fun ElementCardEditMode() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        AddToRmFromSequence()
        InputFlips(
//            modifier = Modifier
//                .weight(5f)
        )
        Text(
            modifier = Modifier
                .weight(15f)
                .width(IntrinsicSize.Max),
            text = "simple lateral mill with turn 180", // elem.title
            color = IronMillerTheme.colorScheme.primary,
        )
        DragElement()
    }

}

@Composable
fun AddToRmFromSequence() {
    // isToggled initial value should be read from a view model or persistent storage.
    var isToggled by rememberSaveable { mutableStateOf(false) }
    IconButton(
        onClick = { isToggled = !isToggled }
    ) {
        Icon(
            painter = if (isToggled) painterResource(R.drawable.button_add_to_seq)
            else painterResource(R.drawable.button_remove_from_seq),
            contentDescription = if (isToggled) "Selected icon button" else "Unselected icon button."
        )
    }
}

@Composable
fun InputFlips(
    modifier: Modifier = Modifier
) {
    var flipValue by remember { mutableStateOf("1") }
    TextField(
        value = flipValue,
        onValueChange = { newText ->
            flipValue = newText.filter { it.isDigit() }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number // Opens numeric keypad
        ),
        modifier = Modifier
//            .width(IntrinsicSize.Max) // min possible width NOT WORKING >:(
            .width(50.dp),
        visualTransformation = PostfixTransformation("x"),
        )
}

@Composable
fun DragElement() {
    // isToggled initial value should be read from a view model or persistent storage.
    var isToggled by rememberSaveable { mutableStateOf(false) }
    IconButton(
        onClick = { isToggled = !isToggled }
    ) {
        Icon(
            painter = painterResource(R.drawable.button_drag),
            contentDescription = if (isToggled) "Selected icon button" else "Unselected icon button."
        )
    }
}

class PostfixTransformation(private val postfix: String) : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        val transformedText = AnnotatedString(text.text + postfix)
        val offsetMapping = object : OffsetMapping {
            override fun originalToTransformed(offset: Int): Int {
                return offset.coerceAtMost(text.length) // Cursor stays before postfix
            }
            override fun transformedToOriginal(offset: Int): Int {
                return offset.coerceAtMost(text.length) // Prevent cursor from going into postfix
            }
        }
        return TransformedText(transformedText, offsetMapping)
    }
}

@Preview(device = "id:pixel_5")
@Composable
private fun ElementCardPreview() {
    IronMillerTheme {
        ElementCardEditMode()
        }
}

//@Preview(
//    device = "id:pixel_5",
//    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL,
//)
//@Preview(device = "spec:parent=pixel_5,orientation=landscape")
//@Preview(
//    device = "spec:parent=pixel_5,orientation=landscape",
//    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL,
//)


//    TextField(
//        state = rememberTextFieldState(initialText = "1"),
////        label = { Text(stringResource(R.string.flips)) },
////            .edit {
////                replace(0, length, text.filter { it.isDigit() })
////            },
//        keyboardOptions = KeyboardOptions(
//            keyboardType = KeyboardType.Number // Opens numeric keypad
//        ),
//        modifier = Modifier
////            .width(IntrinsicSize.Max) // min possible width NOT WORKING >:(
//            .width(50.dp),
//        visualTransformation = PostfixTransformation("x"),
//    )