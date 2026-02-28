package com.example.monchefalgerien

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import com.example.monchefalgerien.ui.MainScreen
import com.example.monchefalgerien.ui.theme.MonChefAlgerienTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            var isDarkMode by remember { mutableStateOf(false) }

            MonChefAlgerienTheme(darkTheme = isDarkMode) {
                MainScreen()
            }
        }
    }
}
