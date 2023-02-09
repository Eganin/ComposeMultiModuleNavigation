package com.example.home_impl.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.home_impl.InternalHomeFeatureApi

@Composable
fun ScreenA(modifier: Modifier, navController: NavHostController) {
    var text by remember {
        mutableStateOf(value = "")
    }

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Screen A. Input parameter value",
            modifier = Modifier.padding(all = 36.dp),
            fontSize = 24.sp
        )

        OutlinedTextField(value = text,
            modifier = Modifier.padding(all = 36.dp),
            onValueChange = {
                text = it
            })

        Button(
            modifier = Modifier.padding(16.dp),
            onClick = {
                navController.navigate(InternalHomeFeatureApi.screenB(parameter = text))
            }) {
            Text("To screen B")
        }
    }
}