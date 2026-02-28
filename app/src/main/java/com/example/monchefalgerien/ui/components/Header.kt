package com.example.monchefalgerien.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Header(
    isDarkMode: Boolean,
    onThemeToggle: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Mon Chef Algérien",
            style = MaterialTheme.typography.headlineSmall
        )

        Switch(
            checked = isDarkMode,
            onCheckedChange = { onThemeToggle() }
        )
    }
}
