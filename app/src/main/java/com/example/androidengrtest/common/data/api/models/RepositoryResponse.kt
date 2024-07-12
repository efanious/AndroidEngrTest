package com.example.androidengrtest.common.data.api.models

import com.google.gson.annotations.SerializedName


data class RepositoryResponse(
    @SerializedName("total_count")val totalCount: Int?,
    @SerializedName("incomplete_results")val incompleteResults: Boolean?,
    val items: List<RepositoryItem>?,
    @SerializedName("total_pages")val totalPages: Int?,
    @SerializedName("total_results")val totalResults: Int?
)
