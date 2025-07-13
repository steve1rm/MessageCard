package me.androidbox.messagecard.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.androidbox.messagecard.theme.MessageCardTheme
import me.androidbox.messagecard.theme.onSurfaceAlt
import me.androidbox.messagecard.theme.urbanist
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun ProfileIcon(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.size(28.dp)
            .background(color = MaterialTheme.colorScheme.primary, shape = CircleShape),
        contentAlignment = Alignment.Center,
        content = {
            Text(
                text = "S",
                fontFamily = urbanist,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onSurfaceAlt
            )
        }
    )
}

@Composable
@Preview
fun ProfileIconPreview() {
    MessageCardTheme {
        ProfileIcon()
    }
}