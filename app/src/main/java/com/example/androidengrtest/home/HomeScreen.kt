package com.example.androidengrtest.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.androidengrtest.Screen
import com.example.androidengrtest.components.RepositoryCardItem
import com.example.androidengrtest.components.UserCardItem
import com.example.androidengrtest.ui.theme.manropeFamily


@Composable
fun HomeScreen(
    modifier: Modifier = Modifier, navController: NavHostController

) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(start = 12.dp, end = 12.dp)

    ) {

        Text(
            text = "Home",
            fontSize = 18.sp,
            color = Color.Black,
            fontFamily = manropeFamily, fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(31.dp))

        Row(
            modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center

        ) {

            UserCardItem(onUserCardClicked = {
                navController.navigate(Screen.Users.route)
            })
            Spacer(modifier = Modifier.width(8.dp))
            RepositoryCardItem(onUserCardClicked = {
                navController.navigate(Screen.Repository.route)
            })

        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewTrendingScreen() {
    //HomeScreen()
}