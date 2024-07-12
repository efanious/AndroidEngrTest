package com.example.androidengrtest.common.data.api

import retrofit2.http.GET
import retrofit2.http.Query
import com.example.androidengrtest.common.data.api.ApiConstants.SEARCH_REPOSITORIES
import com.example.androidengrtest.common.data.api.ApiConstants.SEARCH_USERS
import com.example.androidengrtest.common.data.api.models.RepositoryResponse
import com.example.androidengrtest.common.data.api.models.UsersResponse

interface GitHubApi {

    @GET(SEARCH_REPOSITORIES)
    suspend fun searchRepositories(
        @Query("q") searchQuery: String
    ): RepositoryResponse

    @GET(SEARCH_USERS)
    suspend fun searchUsers(
        @Query("q") searchQuery: String
    ): UsersResponse
}
