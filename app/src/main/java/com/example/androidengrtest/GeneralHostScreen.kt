package com.example.androidengrtest

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.androidengrtest.home.HomeScreen
import com.example.androidengrtest.repository.RepositoryScreen
import com.example.androidengrtest.ui.theme.Pink40
import com.example.androidengrtest.users.UsersScreen

@Composable
fun GeneralHostScreen(
    modifier: Modifier = Modifier
) {

    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavigation (modifier = Modifier.background(color = Color.White)) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                items.forEach { screen ->
                    BottomNavigationItem(
                        icon = {
                            Icon(
                                painter = painterResource(screen.drawResId),
                                contentDescription = screen.route + "Icon",
                                modifier = Modifier.size(width = 20.dp, height = 20.dp),

                            )
                        },
                        selectedContentColor = Color.Black,
                        label = {
                            Text(
                                stringResource(screen.resourceId),
                                maxLines = 1,
                                fontSize = 10.sp
                            )
                        },
                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                        onClick = {
                            navController.navigate(screen.route) {
                                // Pop up to the start destination of the graph to
                                // avoid building up a large stack of destinations
                                // on the back stack as users select items
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                // Avoid multiple copies of the same destination when
                                // reselecting the same item
                                launchSingleTop = true
                                // Restore state when reselecting a previously selected item
                                restoreState = true
                            }
                        }, modifier = Modifier
                            .background(color = Color.White)
                            .padding(1.dp)
                            .align(Alignment.CenterVertically)
                            .weight(1f)
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController,
            startDestination = Screen.Home.route,
            Modifier.padding(innerPadding)
        ) {

            composable(Screen.Home.route) {
                HomeScreen(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding((8.dp)), navController
                )
            }

            composable(Screen.Repository.route) {
                RepositoryScreen(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding((8.dp))
                )
            }
            composable(Screen.Users.route) {
                UsersScreen(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding((8.dp))
                )

            }


        }
    }

}

sealed class Screen(
    val route: String,
    @StringRes val resourceId: Int,
    @DrawableRes val drawResId: Int
) {
    data object Home : Screen("home", R.string.home, R.drawable.home_selected)
    data object Repository : Screen("repository", R.string.repository, R.drawable.search_normal)
    data object Users : Screen("users", R.string.users, R.drawable.user_normal)

}


val items = listOf(
    Screen.Home,
    Screen.Repository,
    Screen.Users
)
