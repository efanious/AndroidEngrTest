package com.example.androidengrtest

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


@Composable
fun MainApp(navController: NavHostController = rememberNavController()) {
    Scaffold(

    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = MainAppScreens.Main.name,
            Modifier.padding(innerPadding)
        ) {


            composable(route = MainAppScreens.Main.name) {
                GeneralHostScreen(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding((8.dp))
                )
            }
        }
    }
}

enum class MainAppScreens(@StringRes val title: Int) {
    Main(title = R.string.home)
}
