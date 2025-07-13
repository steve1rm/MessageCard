package me.androidbox.messagecard.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import messagecard.composeapp.generated.resources.Res
import messagecard.composeapp.generated.resources.urbanist
import org.jetbrains.compose.resources.Font

val urbanist: FontFamily
    @Composable
    get() {
        return FontFamily(
            Font(resource = Res.font.urbanist)
        )
    }
