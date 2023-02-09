package com.example.composemultimodulenavigation.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.dependency_provider.DependencyProvider
import com.example.feature_api.register

@Composable
fun AppNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = DependencyProvider.homeFeature().homeRoute()
    ) {
        register(
            featureApi = DependencyProvider.homeFeature(),
            navController = navController,
            modifier = modifier
        )
    }
}