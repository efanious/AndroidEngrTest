package com.example.androidengrtest.common.data.repositories

import com.example.androidengrtest.common.data.api.models.DetailedUserItem
import com.example.androidengrtest.common.data.api.models.RepositoryItem
import com.example.androidengrtest.common.data.api.models.RepositoryResponse
import com.example.androidengrtest.common.data.api.models.UsersResponse
import kotlinx.coroutines.flow.Flow

interface AllGitHubRepos {
    suspend fun searchRepositories(searchValue: String): Flow<RepositoryResponse>
    suspend fun searchUsers(searchValue: String): Flow<UsersResponse>
    suspend fun getDetailedUser(userName: String): Flow<DetailedUserItem>
    suspend fun getUserRepos(userName: String): Flow<List<RepositoryItem>>
}