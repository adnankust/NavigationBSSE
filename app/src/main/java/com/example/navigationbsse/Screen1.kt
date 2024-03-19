package com.example.navigationbsse

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun Screen1(navController: NavController) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        Text(text = "Screen 1", style = MaterialTheme.typography.h4)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigate("screen2/name") }) {
            Text(text = "Navigate to Screen 2 with name")
        }
    }
}