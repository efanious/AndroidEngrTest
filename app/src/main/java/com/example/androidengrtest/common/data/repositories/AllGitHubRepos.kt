package com.example.androidengrtest.common.data.repositories

import com.example.androidengrtest.common.data.api.models.RepositoryResponse
import com.example.androidengrtest.common.data.api.models.UsersResponse
import kotlinx.coroutines.flow.Flow

interface AllGitHubRepos {
    suspend fun searchRepositories(searchValue: String): Flow<RepositoryResponse>
    suspend fun searchUsers(searchValue: String): Flow<UsersResponse>
}