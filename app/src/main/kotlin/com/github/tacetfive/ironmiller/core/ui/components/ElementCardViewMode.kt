package com.github.tacetfive.ironmiller.core.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.width
import com.github.tacetfive.ironmiller.core.ui.theme.IronMillerTheme
// import android.text.Layout.Alignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Arrangement

@Composable
fun ElementCardViewMode() {
//        Element titles
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
//            Element serial number
        Text(
            modifier = Modifier
//                .weight(1f)
                .width(IntrinsicSize.Max),
            text = "1", // serial number
            color = IronMillerTheme.colorScheme.primary,
        )
//            Element title
        Text(
            modifier = Modifier
                .weight(15f)
                .width(IntrinsicSize.Max),
            text = "simple lateral mill with turn 180", // elem.title
            color = IronMillerTheme.colorScheme.primary,
        )
//            Element difficulty
        Text(
            modifier = Modifier
//                .weight(15f)
                .width(IntrinsicSize.Max),
            text = "A", // elem.difficulty
            color = IronMillerTheme.colorScheme.primary,
        )
//            Element points
        Text(
            modifier = Modifier
                .weight(1.75f)
                .width(IntrinsicSize.Max),
            text = "0.2", // elem.points
            color = IronMillerTheme.colorScheme.primary,
        )
    }
}






@Preview(device = "id:pixel_5")
@Composable
private fun ElementCardPreview() {
    IronMillerTheme {
        ElementCardViewMode()
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