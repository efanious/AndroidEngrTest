package com.example.androidengrtest.users

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.androidengrtest.common.data.api.models.UserItem
import com.example.androidengrtest.components.FailureItem
import com.example.androidengrtest.components.MyButton
import com.example.androidengrtest.components.SearchView
import com.example.androidengrtest.components.UsersListItem
import com.example.androidengrtest.ui.theme.manropeFamily


@Composable
fun UsersScreen(
    modifier: Modifier = Modifier,
    onUserClicked: (UserItem) -> Unit

) {

    val usersViewModel: UsersViewModel = hiltViewModel()

    val searchUsersViewState by usersViewModel.state.collectAsStateWithLifecycle()

    val isLoading = searchUsersViewState.isLoading
    val isError = searchUsersViewState.isError
    val users = searchUsersViewState.users
    val hasSearched = searchUsersViewState.hasSearched

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(start = 12.dp, end = 12.dp)

    ) {

        var search by remember { mutableStateOf("") }

        Text(
            text = "Users",
            fontSize = 18.sp,
            color = Color.Black,
            fontFamily = manropeFamily, fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(10.dp))
        Card(
            modifier = Modifier
                .wrapContentHeight()
                .wrapContentWidth()
        ) {
            Column(
                modifier = Modifier
                    .wrapContentHeight()
                    .wrapContentWidth()
                    .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(6.dp)),
            ) {
                Row(
                    modifier = Modifier.padding(start = 5.dp, end = 5.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    SearchView(search = search, onValueChange = {
                        search = it
                    })

                    MyButton("Search", onButtonClicked = {
                        usersViewModel.searchUsers(search)
                    })

                }
            }
        }

        if (isError) {
            FailureItem(searchUsersViewState.errorMessage)
        } else {
            if (isLoading) {
                Box(modifier = Modifier.fillMaxSize()) {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }
            } else {
                if (users.isEmpty()) {
                    if (hasSearched) {
                        FailureItem("We've searched the ends of the earth. repository not found, please try again")
                    } else {
                        FailureItem("Search Github for repositories, issues and pull requests.")
                    }
                } else {
                    LazyColumn(
                        verticalArrangement = Arrangement.spacedBy(4.dp),
                        modifier = modifier.fillMaxSize(),
                        content = {
                            items(users) { user ->
                                UsersListItem(user, onUserClick = {
                                    onUserClicked(it)
                                })
                            }
                        }
                    )
                }
            }
        }


    }
}


@Preview(showBackground = true)
@Composable
fun PreviewTrendingScreen() {
    //UsersScreen()
}