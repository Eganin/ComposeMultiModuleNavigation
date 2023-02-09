package com.example.settings_impl

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.settings_api.SettingsFeatureApi
import com.example.settings_impl.screens.SettingsScreen

class SettingsFeatureImpl : SettingsFeatureApi {

    private val baseRoute = "settings"

    override fun settingsRoute() = baseRoute

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: Modifier
    ) {
        navGraphBuilder.composable(route = baseRoute) {
            SettingsScreen(modifier = modifier)
        }
    }
}