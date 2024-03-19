package com.example.navigationbsse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.navigationbsse.ui.theme.NavigationBSSETheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationBSSETheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Navigation()
                }
            }
        }
    }
}

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "screen1"){
        composable("screen1") {Screen1(navController)}
        composable(route = "screen2/{name}",
        arguments = listOf(navArgument("name"){type = NavType.StringType})) {
            backStackEntery ->
            Screen2(
                navController,
                name = (backStackEntery.arguments?.getString("name") ?: "" )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NavigationBSSETheme {
        Navigation()
    }
}