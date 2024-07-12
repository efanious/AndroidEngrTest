package com.example.androidengrtest.users.user_details

import com.example.androidengrtest.common.data.api.models.DetailedUserItem
import com.example.androidengrtest.common.data.api.models.RepositoryItem

data class UserDetailsViewState(
    val isLoading: Boolean = false,
    val detailedUser: DetailedUserItem? = null,
    val isError: Boolean = false,
    val errorMessage: String = "An error occurred..",
    val hasSearched: Boolean = false,
    val userRepos: List<RepositoryItem> = emptyList()
)