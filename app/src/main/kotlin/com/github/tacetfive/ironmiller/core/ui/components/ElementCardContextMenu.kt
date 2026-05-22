package com.github.tacetfive.ironmiller.core.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.width
import com.github.tacetfive.ironmiller.core.ui.theme.IronMillerTheme
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.IntrinsicSize

@Composable
fun ElementCardContextMenu() {
    Column(
//        verticalAlignment = Alignment.CenterVertically,
//        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            modifier = Modifier
                .weight(15f)
                .width(IntrinsicSize.Max),
            text = "Duplicate",
            color = IronMillerTheme.colorScheme.primary,
        )
        Text(
            modifier = Modifier
                .weight(15f)
                .width(IntrinsicSize.Max),
            text = "Deactivate", // Activate
            color = IronMillerTheme.colorScheme.primary,
        )
        Text(
            modifier = Modifier
                .weight(15f)
                .width(IntrinsicSize.Max),
            text = "Change element", // Activate
            color = IronMillerTheme.colorScheme.primary,
        )
    }

}


@Preview(device = "id:pixel_5")
@Composable
private fun ElementCardPreview() {
    IronMillerTheme {
        ElementCardContextMenu()
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