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
import com.example.androidengrtest.home.HomeScreen


@Composable
fun MainApp(navController: NavHostController = rememberNavController()) {
    Scaffold(

    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = MainAppScreens.Home.name,
            Modifier.padding(innerPadding)
        ) {


            composable(route = MainAppScreens.Home.name) {
                HomeScreen(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding((8.dp))
                )
            }



        }
    }
}

enum class MainAppScreens(@StringRes val title: Int) {
    Home(title = R.string.home)
}
