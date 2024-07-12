package com.example.androidengrtest.common.data.api

object ApiConstants {

    const val BASE_URL = "https://api.github.com"

    //All API endpoints
    const val SEARCH_REPOSITORIES =  "/search/repositories?"
    const val SEARCH_USERS =  "/search/users?"
    const val GET_DETAILED_USER =  "/users/{username}"
    const val GET_USER_REPOS =  "/users/{username}/repos"
}
