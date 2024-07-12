package com.example.androidengrtest.users.user_details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidengrtest.common.data.api.models.DetailedUserItem
import com.example.androidengrtest.common.data.api.models.RepositoryItem
import com.example.androidengrtest.common.data.repositories.GitHubRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class UserDetailsViewModel @Inject constructor(private val gitHubRepository: GitHubRepository) :
    ViewModel() {

    private val _state = MutableStateFlow(UserDetailsViewState())
    val state: StateFlow<UserDetailsViewState> = _state.asStateFlow()

    private var user: DetailedUserItem? = null
    private var userRepos: List<RepositoryItem>? = null


    fun getDetailedUser(username: String) {

        //Set state to loading
        _state.update { oldState ->
            oldState.copy(
                isLoading = true,
                detailedUser = null,
                isError = false,
                hasSearched = true
            )
        }

        viewModelScope.launch {
            try {
                val latestUserNetwork = gitHubRepository.getDetailedUser(username)
                latestUserNetwork.collect { userItem ->
                    user = userItem
                }
                _state.update { oldState ->
                    oldState.copy(
                        isLoading = false,
                        detailedUser = user,
                        isError = false,
                        hasSearched = true
                    )

                }

            } catch (e: Exception) {
                _state.update { oldState ->
                    e.message?.let {
                        oldState.copy(
                            isLoading = false,
                            detailedUser = null,
                            isError = true,
                            errorMessage = it,
                            hasSearched = true
                        )
                    }!!
                }
            }

        }
    }

    fun getUserRepos(username: String) {

        viewModelScope.launch {
            try {
                val latestUserRepos = gitHubRepository.getUserRepos(username)
                latestUserRepos.collect {
                    userRepos = it
                }
                _state.update { oldState ->

                    oldState.copy(
                        isLoading = false,
                        userRepos = userRepos!!,
                        isError = false,
                        hasSearched = true
                    )
                }

            } catch (e: Exception) {
                _state.update { oldState ->
                    e.message?.let {
                        oldState.copy(
                            isLoading = false,
                            userRepos = emptyList(),
                            isError = true,
                            errorMessage = it,
                            hasSearched = true
                        )
                    }!!
                }
            }

        }
    }
}


