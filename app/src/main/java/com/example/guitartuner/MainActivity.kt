package com.example.guitartuner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.compose.*
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                GuitarTunerApp()
            }
        }
    }
}

sealed class Screen(val route: String, val label: String, val emoji: String) {
    object Tuner : Screen("tuner", "Tuner", "🎛")
    object Standards : Screen("standards", "Standards", "⚙")
    object Presets : Screen("presets", "Presets", "🎸")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GuitarTunerApp() {
    val navController = rememberNavController()
    val items = listOf(Screen.Tuner, Screen.Standards, Screen.Presets)
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Guitar Tuner",
                        fontWeight = FontWeight.Bold
                    )
                }
            )
        },
        bottomBar = {
            NavigationBar {
                items.forEach { screen ->
                    NavigationBarItem(
                        selected = currentRoute == screen.route,
                        onClick = {
                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.startDestinationId) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = { Text(screen.emoji) },
                        label = { Text(screen.label) }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Tuner.route
        ) {
            composable(Screen.Tuner.route) {
                TunerScreen(innerPadding)
            }
            composable(Screen.Standards.route) {
                StandardsScreen(innerPadding)
            }
            composable(Screen.Presets.route) {
                PresetsScreen(innerPadding)
            }
        }
    }
}