package com.example.androidengrtest.common.data.api.models

import com.google.gson.annotations.SerializedName


data class RepositoryItem(
    val id: Int?,
    @SerializedName("node_id")
    val nodeId: String?,
    val name: String?,
    @SerializedName("full_name")
    val fullName: String?,
    val private: Boolean?,
    val owner: OwnerData?,
    @SerializedName("html_url")
    val htmlUrl: String?,
    val description: String?,
    val fork: Boolean?,
    val url: String?,
    @SerializedName("forks_url")
    val forksUrl: String?,
    @SerializedName("keys_url")
    val keysUrl: String?,
    @SerializedName("collaborators_url")
    val collaboratorsUrl: String?,
    @SerializedName("teams_url")
    val teamsUrl: String?,
    @SerializedName("hooks_url")
    val hooksUrl: String?,
    @SerializedName("issue_events_url")
    val issueEventsUrl: String?,
    @SerializedName("events_url")
    val eventsUrl: String?,
    @SerializedName("assignees_url")
    val assigneesUrl: String?,
    @SerializedName("branches_url")
    val branchesUrl: String?,
    @SerializedName("tags_url")
    val tagsUrl: String?,
    @SerializedName("blobs_url")
    val blobsUrl: String?,
    @SerializedName("git_tags_url")
    val gitTagsUrl: String?,
    @SerializedName("git_refs_url")
    val gitRefsUrl: String?,
    @SerializedName("trees_url")
    val treesUrl: String?,
    @SerializedName("statuses_url")
    val statusesUrl: String?,
    @SerializedName("languages_url")
    val languagesUrl: String?

)
