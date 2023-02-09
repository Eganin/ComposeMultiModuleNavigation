package com.example.home_impl

import androidx.compose.ui.Modifier
import androidx.navigation.*
import androidx.navigation.compose.composable
import com.example.feature_api.FeatureApi
import com.example.home_impl.screens.ScreenA
import com.example.home_impl.screens.ScreenB

object InternalHomeFeatureApi : FeatureApi {

    private const val scenarioABRoute = "home/scenarioABRoute"
    private const val parameterKey = "parameterKey"
    private const val screenBRoute = "home/screenB"
    private const val screenARoute = "home/screenA"

    fun scenarioABRoute() = scenarioABRoute

    fun screenA() = screenARoute

    fun screenB(parameter: String) = "$screenBRoute/${parameter}"

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: Modifier
    ) {
        navGraphBuilder.navigation(
            route = scenarioABRoute,
            startDestination = screenARoute
        ) {
            composable(route = screenARoute) {
                ScreenA(modifier = modifier, navController = navController)
            }

            composable(
                route = "$screenBRoute/$parameterKey",
                arguments = listOf(navArgument(parameterKey) { type = NavType.StringType })
            ) { entry ->
                val arguments = requireNotNull(entry.arguments)
                val argument = arguments.getString(parameterKey).orEmpty()
                ScreenB(argument = argument, modifier = modifier)
            }
        }
    }
}