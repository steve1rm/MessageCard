package me.androidbox.messagecard.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.androidbox.messagecard.MessageStatusType
import me.androidbox.messagecard.theme.MessageCardTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun MessageStatus(
    modifier: Modifier = Modifier,
    statusText: String,
    textColor: Color,
    icon: @Composable () -> Unit
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(4.dp, alignment = Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically
    ) {
        icon()

        Text(
            text = statusText,
            color = textColor,
            fontWeight = FontWeight.Normal,
            lineHeight = 20.sp,
            fontSize = 11.sp,
        )
    }
}

@Composable
@Preview
fun MessageStatusPreview() {
    MessageCardTheme {
        MessageStatus(
            statusText = MessageStatusType.READ.status,
            icon = {
                MessageStatusType.READ.icon
            },
            textColor = MessageStatusType.READ.color()
        )
    }
}