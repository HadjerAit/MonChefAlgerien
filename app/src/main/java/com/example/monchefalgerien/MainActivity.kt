package com.example.monchefalgerien

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.monchefalgerien.ui.MainScreen
import com.example.monchefalgerien.ui.theme.MonChefAlgerienTheme
import com.example.monchefalgerien.viewmodel.RecetteViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val vm: RecetteViewModel = viewModel()
            val darkTheme by vm.darkTheme.collectAsState()

            MonChefAlgerienTheme(darkTheme = darkTheme) {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .safeDrawingPadding()
                ) {
                    MainScreen(vm = vm)
                }
            }
        }
    }
}