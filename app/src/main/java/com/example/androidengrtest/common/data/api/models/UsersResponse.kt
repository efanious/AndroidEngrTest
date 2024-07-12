package com.example.androidengrtest.common.data.api.models

import com.google.gson.annotations.SerializedName


data class UsersResponse(
    @SerializedName("total_count")val totalCount: Int?,
    @SerializedName("incomplete_results")val incompleteResults: Boolean?,
    val items: List<UserItem>?
)