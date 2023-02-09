package com.example.onboarding_impl

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.onboarding_api.OnBoardingFeatureApi
import com.example.onboarding_impl.screens.OnBoardingScreen

class OnBoardingFeatureImpl : OnBoardingFeatureApi {

    private val baseRoute = "onboarding"

    override fun onBoardingRoute() = baseRoute

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: Modifier
    ) {
        navGraphBuilder.composable(route = baseRoute) {
            OnBoardingScreen(navController = navController)
        }
    }
}