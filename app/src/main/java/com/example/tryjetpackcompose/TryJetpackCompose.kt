package com.example.tryjetpackcompose

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.tryjetpackcompose.navigation.HostNavigation
import com.example.tryjetpackcompose.ui.theme.TryJetpackComposeTheme

@Composable
fun TryJetpackCompose(
    navHostController: NavHostController
) {
    TryJetpackComposeTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            HostNavigation(
                navHostController = navHostController
            )
        }
    }
}
