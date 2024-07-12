package com.example.androidengrtest.repository

import com.example.androidengrtest.common.data.api.models.RepositoryItem


data class RepositoryViewState (
    val isLoading: Boolean = false,
    val repositories : List<RepositoryItem> = emptyList(),
    val isError: Boolean = false,
    val errorMessage: String = "An error occurred..",
    val hasSearched: Boolean = false,
)