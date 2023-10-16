package com.example.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tryjetpackcompose.ui.theme.TryJetpackComposeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DisplayApiRoute() {
    val state = rememberDisplayApi()

    DisplayApiScreen(
        state = state.uiStateDisplayApi
    )
}


@Composable
fun DisplayApiScreen(
    state: UiStateDisplayApi,
) {
    Scaffold(
        topBar = {
            Surface {
                Box(
                    modifier = Modifier
                        .background(Color.Black)
                        .fillMaxWidth()
                        .statusBarsPadding(),
                ) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        text = "API表示画面じゃ",
                        textAlign = TextAlign.Center,
                        fontSize = with(LocalDensity.current) { 16.dp.toSp() },
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                    )
                }
            }
        },
    ) {
        state.article?.forEach { article ->
            Column(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    modifier = Modifier,
                    text = article.title,
                )
            }
        }
//        Column(
//            modifier = Modifier
//                .padding(it)
//                .fillMaxSize(),
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally,
//
//            ) {
//            Text(
//                modifier = Modifier,
//                text = "世界終わったよ...",
//            )
//            Button(
//                modifier = Modifier,
//                onClick = {},
//            ) {
//                Text(
//                    modifier = Modifier,
//                    text = "押したら戻れるかも",
//                )
//            }
//        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDisplayApiScreen() {
    TryJetpackComposeTheme {
        DisplayApiScreen(
            state = UiStateDisplayApi()
        )
    }
}
