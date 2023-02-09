package com.example.composemultimodulenavigation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import com.example.composemultimodulenavigation.ui.theme.ComposeMultiModuleNavigationTheme
import com.example.dependency_provider.DependencyProvider
import com.example.home_impl.HomeFeatureImpl

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, true)

        DependencyProvider.provideImpl(
            homeFeatureApi = HomeFeatureImpl()
        )

        setContent {
            ComposeMultiModuleNavigationTheme {
                AppContent()
            }
        }
    }
}