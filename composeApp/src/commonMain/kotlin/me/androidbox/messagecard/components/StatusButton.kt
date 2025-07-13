package me.androidbox.messagecard.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.androidbox.messagecard.theme.MessageCardTheme
import me.androidbox.messagecard.theme.urbanist
import messagecard.composeapp.generated.resources.Res
import messagecard.composeapp.generated.resources.read
import org.jetbrains.compose.resources.vectorResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun StatusButton(
    modifier: Modifier = Modifier,
    enabled: Boolean = false,
    text: String,
    icon: @Composable () -> Unit,
    onClicked: () -> Unit
) {
    Surface(
        modifier = modifier
            .size(width = 240.dp, height = 48.dp)
            .clickable(
                onClick = onClicked
            ),
        color = Color.Transparent,
        shape = RectangleShape,
        border = BorderStroke(width = 1.dp, if(enabled) MaterialTheme.colorScheme.onSurfaceVariant else MaterialTheme.colorScheme.primary),
        content = {
            Row(
                modifier = Modifier.wrapContentSize(
                    align = Alignment.Center
                )
            ) {
                icon()

                Text(
                    text = text,
                    fontFamily = urbanist,
                    fontWeight = FontWeight.SemiBold,
                    lineHeight = 24.sp,
                    fontSize = 16.sp,
                    color = if(enabled) MaterialTheme.colorScheme.onSurfaceVariant else MaterialTheme.colorScheme.primary
                )
            }
        }
    )
}

@Preview
@Composable
fun StatusButtonPreview() {
    MessageCardTheme {
        StatusButton(
            enabled = false,
            text = "Mark as Delivered",
            icon = {
                Icon(
                    imageVector = vectorResource(Res.drawable.read),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary
                )
            },
            onClicked = {

            }
        )
    }
}
