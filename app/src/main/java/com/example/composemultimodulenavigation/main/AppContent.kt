package com.example.composemultimodulenavigation.main

import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.composemultimodulenavigation.ui.theme.Teal200
import java.util.*

@Composable
fun AppContent() {
    val tabs = remember {
        BottomTabs.values()
    }.toList()
    val navController = rememberNavController()
    Scaffold(
        backgroundColor = Teal200,
        bottomBar = {
            BottomBar(
                navController = navController,
                tabs = tabs
            )
        }
    ) { paddingValues ->
        AppNavGraph(
            navController = navController,
            modifier = Modifier.padding(all = paddingValues.calculateBottomPadding())
        )
    }
}

@Composable
fun BottomBar(navController: NavController, tabs: List<BottomTabs>) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: BottomTabs.HOME.route
    val routes = remember {
        BottomTabs.values().map { it.route }
    }

    if (currentRoute in routes) {
        BottomNavigation {
            tabs.map { tab ->
                BottomNavigationItem(
                    icon = {
                        Icon(
                            painter = painterResource(id = tab.icon),
                            contentDescription = tab.route
                        )
                    },
                    label = { Text(text = stringResource(id = tab.title).uppercase(locale = Locale.getDefault())) },
                    selected = currentRoute == tab.route,
                    alwaysShowLabel = false,
                    selectedContentColor = MaterialTheme.colors.secondary,
                    unselectedContentColor = LocalContentColor.current,
                    modifier = Modifier.navigationBarsPadding(),
                    onClick = {
                        if (tab.route != currentRoute) {
                            navController.navigate(tab.route) {
                                popUpTo(navController.graph.startDestinationId) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    })
            }
        }
    }
}