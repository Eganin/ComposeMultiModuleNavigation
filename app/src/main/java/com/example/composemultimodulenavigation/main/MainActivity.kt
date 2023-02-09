package com.example.composemultimodulenavigation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import com.example.composemultimodulenavigation.ui.theme.ComposeMultiModuleNavigationTheme
import com.example.dependency_provider.DependencyProvider
import com.example.home_impl.HomeFeatureImpl
import com.example.settings_impl.SettingsFeatureImpl

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, true)

        DependencyProvider.provideImpl(
            homeFeatureApi = HomeFeatureImpl(),
            settingsFeatureApi = SettingsFeatureImpl()
        )

        setContent {
            ComposeMultiModuleNavigationTheme {
                AppContent()
            }
        }
    }
}