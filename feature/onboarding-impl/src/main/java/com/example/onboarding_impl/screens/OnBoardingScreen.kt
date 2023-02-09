package com.example.onboarding_impl.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.dependency_provider.DependencyProvider

@Composable
internal fun OnBoardingScreen(navController: NavHostController,modifier: Modifier=Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = "Hello world! You're in onboarding screen",
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(36.dp),
            fontSize = 24.sp
        )
        BoardButton(text = "To home") {
            val homeFeature = DependencyProvider.homeFeature()
            navController.popBackStack()
            navController.navigate(homeFeature.homeRoute())
        }

        BoardButton(text = "To settings") {
            val settingsFeature = DependencyProvider.settingsFeature()
            navController.popBackStack()
            navController.navigate(settingsFeature.settingsRoute())
        }
    }
}

@Composable
internal fun BoardButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier.padding(all = 16.dp)
    ) {
        Text(text = text)
    }
}