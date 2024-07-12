package com.example.androidengrtest.repository

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
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
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.androidengrtest.components.CircularImageContent
import com.example.androidengrtest.components.FailureItem
import com.example.androidengrtest.components.Header
import com.example.androidengrtest.components.MyButton
import com.example.androidengrtest.components.RepositoryItemCard
import com.example.androidengrtest.components.SearchView
import com.example.androidengrtest.ui.theme.manropeFamily


@Composable
fun RepositoryScreen(
    modifier: Modifier = Modifier

) {

    val repositoryViewModel: RepositoryViewModel = hiltViewModel()
    val searchViewState by repositoryViewModel.state.collectAsStateWithLifecycle()

    val isLoading = searchViewState.isLoading
    val isError = searchViewState.isError
    val repositories = searchViewState.repositories
    val hasSearched = searchViewState.hasSearched
    val errorMessage = searchViewState.errorMessage


    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(start = 12.dp, end = 12.dp)
    )
    {

        var search by remember { mutableStateOf("") }

        Text(
            text = "Repositories",
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
                        repositoryViewModel.searchRepositories(search)
                    })

                }
            }
        }



        if (isLoading) {
            Box(modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        } else if (isError) {
            FailureItem(errorMessage)
        } else {
            if (repositories.isEmpty()) {
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
                        items(repositories) { repository ->

                            repository.name?.let {

                                RepositoryItemCard(repository)
                            }

                        }
                    }
                )
            }

        }


    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTrendingScreen() {
    RepositoryScreen()
}