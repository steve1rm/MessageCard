package me.androidbox.messagecard.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val ColorScheme.surfaceAlt: Color
    get() {
        return Color(0xFFFFFFFF).copy(alpha = 0.30f)
    }

val ColorScheme.onSurfaceAlt: Color
    get() {
        return Color(0xFF0F0F18)
    }

val ColorScheme.blue: Color
    get() {
        return Color(0xFF68C3FF)
    }

val ColorScheme.backgroundGradient: Brush
    get() {
        return  Brush.verticalGradient(
            listOf(Color(0xFF06060A), Color(0xFF0F1318))
        )
    }

val Primary = Color(0xFF75FABF)
val Surface = Color(0xff1F222A).copy(alpha = 0.50f)
val OnSurface = Color(0xFFFFFFFF)
val OnSurfaceVariant = Color(0xFFAFB2B9)
