package com.example.androidengrtest.users.user_details

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.androidengrtest.R
import com.example.androidengrtest.common.data.api.models.UserItem
import com.example.androidengrtest.components.FailureItem
import com.example.androidengrtest.components.ImageContent
import com.example.androidengrtest.components.RepositoryItemCard
import com.example.androidengrtest.ui.theme.manropeFamily


@Composable
fun UserDetailsScreen(
    modifier: Modifier = Modifier,
    selectedUser: UserItem

) {

    val userViewModel: UserDetailsViewModel = hiltViewModel()

    val detailedUserViewState by userViewModel.state.collectAsStateWithLifecycle()

    val isLoading = detailedUserViewState.isLoading
    val isError = detailedUserViewState.isError
    val user = detailedUserViewState.detailedUser
    val hasSearched = detailedUserViewState.hasSearched
    val repos = detailedUserViewState.userRepos

    selectedUser.login?.let { userViewModel.getDetailedUser(it) }
    selectedUser.login?.let { userViewModel.getUserRepos(it) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(start = 12.dp, end = 12.dp)

    ) {


        Text(
            text = "Users",
            fontSize = 18.sp,
            color = Color.Black,
            fontFamily = manropeFamily, fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(10.dp))

        if (isLoading) {
            Box(modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        } else {
            if (isError) {
                FailureItem(detailedUserViewState.errorMessage)
            } else if (user == null) {
                if (hasSearched) {
                    FailureItem("We've searched the ends of the earth. user not found, please try again")
                } else {
                    FailureItem("Search Github for repositories, issues and pull requests.")
                }
            } else {

                Row(
                    modifier = Modifier.padding(start = 12.dp, end = 12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    user.avatarUrl?.let { ImageContent(it) }
                    Spacer(modifier = Modifier.width(8.dp))

                    user.login?.let {
                        Text(
                            text = it,
                            color = Color.Black,
                            fontSize = 16.sp,
                            fontFamily = manropeFamily, fontWeight = FontWeight.Bold,
                            maxLines = 1
                        )
                    }

                }

                Spacer(modifier = Modifier.height(18.dp))
                user.bio?.let {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth(),
                        text = it,
                        fontSize = 12.sp,
                        color = Color.Black,
                        fontFamily = manropeFamily, fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.height(18.dp))
                Row {

                    if (!user.location.isNullOrEmpty()) {

                        Image(
                            painter = painterResource(id = R.drawable.location_ic),
                            contentDescription = "location",
                            Modifier
                                .size(15.dp)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            modifier = Modifier
                                .wrapContentWidth(),
                            text = "${user.location}",
                            fontSize = 10.sp,
                            color = Color.Black,
                            fontFamily = manropeFamily, fontWeight = FontWeight.Normal
                        )
                    }

                    Spacer(modifier = Modifier.width(8.dp))

                    if (!user.email.isNullOrEmpty()) {
                        Image(
                            painter = painterResource(id = R.drawable.link_ic),
                            contentDescription = "followers",
                            Modifier
                                .size(15.dp)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            modifier = Modifier
                                .wrapContentWidth(),
                            text = "${user.email}",
                            fontSize = 10.sp,
                            color = Color.Black,
                            fontFamily = manropeFamily, fontWeight = FontWeight.Normal
                        )
                    }


                }

                Spacer(modifier = Modifier.height(18.dp))

                Row {
                    Image(
                        painter = painterResource(id = R.drawable.people_ic),
                        contentDescription = "followers",
                        Modifier
                            .size(15.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        modifier = Modifier
                            .wrapContentWidth(),
                        text = "${user.followers} Followers",
                        fontSize = 10.sp,
                        color = Color.Black,
                        fontFamily = manropeFamily, fontWeight = FontWeight.Normal
                    )
                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        modifier = Modifier
                            .wrapContentWidth(),
                        text = "${user.following} Following",
                        fontSize = 10.sp,
                        color = Color.Black,
                        fontFamily = manropeFamily, fontWeight = FontWeight.Normal
                    )

                }

                Spacer(modifier = Modifier.height(10.dp))

                Divider(
                    color = Color.Black,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                )

                if (repos.isNotEmpty()) {
                    LazyColumn(
                        verticalArrangement = Arrangement.spacedBy(4.dp),
                        modifier = modifier.fillMaxSize(),
                        content = {
                            items(repos) { repository ->

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
}
