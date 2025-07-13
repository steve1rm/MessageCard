package me.androidbox.messagecard

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import me.androidbox.messagecard.theme.blue
import messagecard.composeapp.generated.resources.Res
import messagecard.composeapp.generated.resources.read
import messagecard.composeapp.generated.resources.unread
import org.jetbrains.compose.resources.DrawableResource

enum class MessageStatusType(val status: String, val icon: DrawableResource, val color: @Composable () -> Color) {
    SENT(
        status = "Sent",
        color = {
            MaterialTheme.colorScheme.onSurfaceVariant
        },
        icon = Res.drawable.unread
    ),
    DELIVERED(
        status = "Delivered",
        color = {
            MaterialTheme.colorScheme.onSurfaceVariant
        },
        icon = Res.drawable.read
    ),
    READ(
        status = "Read",
        color = {
            MaterialTheme.colorScheme.blue
        },
        icon = Res.drawable.read
    )
}