package com.example.home_impl.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.home_impl.InternalHomeFeatureApi

@Composable
fun HomeScreen(modifier: Modifier, navController: NavHostController) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Home",
            modifier = Modifier.padding(all = 36.dp)
        )

        Button(
            modifier = Modifier.padding(all = 16.dp),
            onClick = {
                navController.navigate(InternalHomeFeatureApi.scenarioABRoute())
            }) {
            Text(text = "Navigate to A-B scenario")
        }
    }
}