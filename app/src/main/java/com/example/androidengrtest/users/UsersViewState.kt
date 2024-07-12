package com.example.androidengrtest.users

import com.example.androidengrtest.common.data.api.models.UserItem


data class UsersViewState (
    val isLoading: Boolean = false,
    val users : List<UserItem> = emptyList(),
    val isError: Boolean = false,
    val errorMessage: String = "An error occurred..",
    val hasSearched: Boolean = false,
)