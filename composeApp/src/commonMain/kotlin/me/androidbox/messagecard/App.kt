package me.androidbox.messagecard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import me.androidbox.messagecard.theme.MessageCardTheme
import me.androidbox.messagecard.theme.backgroundGradient
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MessageCardTheme {
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .background(brush = MaterialTheme.colorScheme.backgroundGradient),
            containerColor = Color.Transparent
        ) { paddingValues ->
            MessageCardScreen(
                modifier = Modifier.padding(paddingValues)
            )
        }
    }
}