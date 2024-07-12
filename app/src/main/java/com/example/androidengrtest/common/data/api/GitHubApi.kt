package com.example.androidengrtest.common.data.api

import com.example.androidengrtest.common.data.api.ApiConstants.GET_DETAILED_USER
import com.example.androidengrtest.common.data.api.ApiConstants.GET_USER_REPOS
import retrofit2.http.GET
import retrofit2.http.Query
import com.example.androidengrtest.common.data.api.ApiConstants.SEARCH_REPOSITORIES
import com.example.androidengrtest.common.data.api.ApiConstants.SEARCH_USERS
import com.example.androidengrtest.common.data.api.models.DetailedUserItem
import com.example.androidengrtest.common.data.api.models.RepositoryItem
import com.example.androidengrtest.common.data.api.models.RepositoryResponse
import com.example.androidengrtest.common.data.api.models.UsersResponse
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Path

interface GitHubApi {

    @GET(SEARCH_REPOSITORIES)
    suspend fun searchRepositories(
        @Query("q") searchQuery: String
    ): RepositoryResponse

    @GET(SEARCH_USERS)
    suspend fun searchUsers(
        @Query("q") searchQuery: String
    ): UsersResponse

    @GET(GET_DETAILED_USER)
    suspend fun getUserDetails(
        @Path("username") username: String, @Header("Authorization") authorization: String
    ): DetailedUserItem
    @GET(GET_USER_REPOS)
    suspend fun getUserRepos(
        @Path("username") username: String, @Header("Authorization") authorization: String
    ): List<RepositoryItem>


}
