package com.example.androidengrtest.common.data.repositories

import com.example.androidengrtest.common.data.api.GitHubApi
import com.example.androidengrtest.common.data.api.models.RepositoryResponse
import com.example.androidengrtest.common.data.api.models.UsersResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class GitHubRepository @Inject constructor(private val githubApi: GitHubApi) :
    AllGitHubRepos {

    override suspend fun searchRepositories(searchValue: String): Flow<RepositoryResponse> {
        return flow {
            val response = githubApi.searchRepositories(searchQuery = searchValue)
            emit(response)
        }
    }

    override suspend fun searchUsers(searchValue: String): Flow<UsersResponse> {
        return flow {
            val response = githubApi.searchUsers(searchQuery = searchValue)
            emit(response)
        }
    }
}