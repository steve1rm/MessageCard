package me.androidbox.messagecard.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.androidbox.messagecard.MessageStatusType
import me.androidbox.messagecard.theme.MessageCardTheme
import me.androidbox.messagecard.theme.surfaceAlt
import me.androidbox.messagecard.theme.urbanist
import org.jetbrains.compose.resources.vectorResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun MessageCard(
    modifier: Modifier = Modifier,
    messageStatusType: MessageStatusType
) {
    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.background,
        shape = RoundedCornerShape(size = 22.dp),
        content = {
            Column(
                modifier = Modifier.fillMaxWidth().padding(top = 12.dp, end = 20.dp, bottom = 12.dp, start = 20.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "DreamSyntaxHiker",
                        fontFamily = urbanist,
                        fontWeight = FontWeight.SemiBold,
                        lineHeight = 18.sp,
                        fontSize = 14.sp,
                        color = MaterialTheme.colorScheme.onSurface
                    )

                    Text(
                        text = "1 day ago",
                        fontFamily = urbanist,
                        fontWeight = FontWeight.Medium,
                        lineHeight = 16.sp,
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.surfaceAlt
                    )
                }

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = "Iʼll send the draft tonight.I spent 9 months building what I thought would be a simple app to help people learn new languages through short conversations. I poured my evenings and weekends into it, but the launch was... underwhelming.",
                    textAlign = TextAlign.Start,
                    fontFamily = urbanist,
                    fontWeight = FontWeight.Normal,
                    lineHeight = 20.sp,
                    fontSize = 16.sp,
                    color = MaterialTheme.colorScheme.onSurface
                )

                Spacer(modifier = Modifier.height(6.dp))

                MessageStatus(
                    statusText = messageStatusType.status,
                    textColor = messageStatusType.color(),
                    icon = {
                        Icon(
                            imageVector = vectorResource(messageStatusType.icon),
                            contentDescription = null,
                            tint = messageStatusType.color()
                        )
                    }
                )
            }
        }
    )
}

@Composable
@Preview
fun MessageCardPreview() {
    MessageCardTheme {
        MessageCard(
            messageStatusType = MessageStatusType.READ
        )
    }
}