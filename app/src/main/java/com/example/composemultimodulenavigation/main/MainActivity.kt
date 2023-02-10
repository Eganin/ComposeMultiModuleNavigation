package com.example.composemultimodulenavigation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.arkivanov.decompose.defaultComponentContext
import com.example.composemultimodulenavigation.main.decomposetest.AuthorizationRepository
import com.example.composemultimodulenavigation.main.decomposetest.RealSignInComponent
import com.example.composemultimodulenavigation.main.decomposetest.SignInUi
import com.example.composemultimodulenavigation.ui.theme.ComposeMultiModuleNavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        WindowCompat.setDecorFitsSystemWindows(window, true)
//
//        DependencyProvider.provideImpl(
//            homeFeatureApi = HomeFeatureImpl(),
//            settingsFeatureApi = SettingsFeatureImpl(),
//            onBoardingFeatureApi = OnBoardingFeatureImpl()
//        )
//
//        setContent {
//            ComposeMultiModuleNavigationTheme {
//                AppContent()
//            }
//        }

        val rootComponent = RealSignInComponent(
            componentContext = defaultComponentContext(),
            authorizationRepository = AuthorizationRepository.Base()
        )

        setContent {
            ComposeMultiModuleNavigationTheme {
                SignInUi(component = rootComponent)
            }
        }
    }
}