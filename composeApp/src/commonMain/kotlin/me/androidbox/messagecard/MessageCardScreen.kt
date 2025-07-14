package me.androidbox.messagecard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import me.androidbox.messagecard.components.MessageCard
import me.androidbox.messagecard.components.ProfileIcon
import me.androidbox.messagecard.components.StatusButton
import messagecard.composeapp.generated.resources.Res
import messagecard.composeapp.generated.resources.read
import messagecard.composeapp.generated.resources.unread
import org.jetbrains.compose.resources.vectorResource

enum class MessageButtonState {
    SENT,
    DELIVERED,
    READ,
}

@Composable
fun MessageCardScreen(
    modifier: Modifier = Modifier
) {
    var activeButton by rememberSaveable {
        mutableStateOf(MessageButtonState.SENT)
    }

    var currentMessageStatusType by rememberSaveable {
        mutableStateOf(MessageStatusType.SENT) // Default status for MessageCard
    }

    LaunchedEffect(activeButton) {
        currentMessageStatusType = when (activeButton) {
            MessageButtonState.SENT -> MessageStatusType.SENT
            MessageButtonState.DELIVERED -> MessageStatusType.DELIVERED
            MessageButtonState.READ -> MessageStatusType.READ
        }
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth().align(alignment = Alignment.Center),
            verticalAlignment = Alignment.Bottom
        ) {
            ProfileIcon()

            Spacer(modifier = Modifier.width(width = 8.dp))

            MessageCard(
                messageStatusType = currentMessageStatusType
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(alignment = Alignment.BottomCenter),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            StatusButton(
                text = "Mark as Sent",
                icon = {
                    Icon(
                        imageVector = vectorResource(Res.drawable.unread),
                        contentDescription = null,
                        tint =  if(activeButton == MessageButtonState.SENT) MaterialTheme.colorScheme.onSurfaceVariant else MaterialTheme.colorScheme.primary
                    )
                },
                onClicked = {
                    activeButton = MessageButtonState.SENT
                },
                enabled = activeButton == MessageButtonState.SENT
            )

            StatusButton(
                text = "Mark as Delivered",
                icon = {
                    Icon(
                        imageVector = vectorResource(Res.drawable.read),
                        contentDescription = null,
                        tint = if(activeButton == MessageButtonState.DELIVERED) MaterialTheme.colorScheme.onSurfaceVariant else MaterialTheme.colorScheme.primary
                    )
                },
                onClicked = {
                    activeButton = MessageButtonState.DELIVERED
                },
                enabled = activeButton == MessageButtonState.DELIVERED
            )

            StatusButton(
                text = "Mark as Read",
                icon = {
                    Icon(
                        imageVector = vectorResource(Res.drawable.read),
                        contentDescription = null,
                        tint = if(activeButton == MessageButtonState.READ) MaterialTheme.colorScheme.onSurfaceVariant else MaterialTheme.colorScheme.primary
                    )
                },
                onClicked = {
                    activeButton = MessageButtonState.READ
                },
                enabled = activeButton == MessageButtonState.READ
            )

            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}