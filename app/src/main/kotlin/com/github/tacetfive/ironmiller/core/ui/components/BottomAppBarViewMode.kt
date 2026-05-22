package com.github.tacetfive.ironmiller.core.ui.components

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.github.tacetfive.ironmiller.R
import androidx.compose.material3.Text
// import android.text.Layout.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.material3.Scaffold
import androidx.compose.material3.BottomAppBar
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer

@Preview
@Composable
fun BottomAppBarViewMode() {
    Scaffold(
        bottomBar = {
            BottomAppBar(
                actions = {
                    Spacer(modifier = Modifier.weight(0.1f))
                    IconButton(
                        onClick = { /* turn into Select mode */ }
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.button_select_mode),
                            contentDescription = "Localized description"
                        )
                    }
                    IconButton(onClick = { /* turn into Edit mode */ }) {
                        Icon(
                            painter = painterResource(R.drawable.button_edit_mode),
                            contentDescription = "Localized description",
                        )
                    }
                    IconButton(onClick = { /* turn into Blocks edit mode */ }) {
                        Icon(
                            painter = painterResource(R.drawable.button_edit_blocks_mode),
                            contentDescription = "Localized description",
                        )
                    }
                    Spacer(modifier = Modifier.weight(0.1f))
                    IconButton(onClick = { /* show/hide sequences and blocks points */ }) {
                        Icon(
                            painter = painterResource(R.drawable.button_show_aux_points),
                            contentDescription = "Localized description",
                        )
                    }
                    Spacer(modifier = Modifier.weight(0.1f))
                },
            )
        },
    ) { innerPadding ->
        Text(
            modifier = Modifier.padding(innerPadding),
            text = "Example of a scaffold with a bottom app bar."
        )
    }
}

//@Preview
//@Composable
//fun BottomAppBarViewMode() {
//    Row() {
//        Spacer(modifier = Modifier.weight(0.1f))
//        IconButton(
//            onClick = { /* turn into Select mode */ }
//        ) {
//            Icon(
//                painter = painterResource(R.drawable.button_select_mode),
//                contentDescription = "Localized description"
//            )
//        }
//        IconButton(onClick = { /* turn into Edit mode */ }) {
//            Icon(
//                painter = painterResource(R.drawable.button_edit_mode),
//                contentDescription = "Localized description",
//            )
//        }
//        IconButton(onClick = { /* turn into Blocks edit mode */ }) {
//            Icon(
//                painter = painterResource(R.drawable.button_edit_blocks_mode),
//                contentDescription = "Localized description",
//            )
//        }
//        Spacer(modifier = Modifier.weight(1f))
//        IconButton(onClick = { /* show/hide sequences and blocks points */ }) {
//            Icon(
//                painter = painterResource(R.drawable.button_show_aux_points),
//                contentDescription = "Localized description",
//            )
//        }
//    }
//}

