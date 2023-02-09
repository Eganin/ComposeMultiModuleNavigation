package com.example.home_impl

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.home_api.HomeFeatureApi
import com.example.home_impl.screens.HomeScreen

class HomeFeatureImpl : HomeFeatureApi {

    private val baseRoute = "home"

    override fun homeRoute() = baseRoute

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: Modifier
    ) {
        navGraphBuilder.composable(route = baseRoute) {
            HomeScreen(modifier = modifier, navController = navController)
        }
        InternalHomeFeatureApi.registerGraph(
            navGraphBuilder = navGraphBuilder,
            navController = navController,
            modifier = modifier
        )
    }
}