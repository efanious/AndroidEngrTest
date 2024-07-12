package com.example.androidengrtest.users

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidengrtest.common.data.api.models.UserItem
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
class UsersViewModel @Inject constructor(private val gitHubRepository: GitHubRepository) :
    ViewModel() {


    private val _state = MutableStateFlow(UsersViewState())
    val state: StateFlow<UsersViewState> = _state.asStateFlow()

    private var usersList: List<UserItem>? = null

    fun searchUsers(search: String) {

        //Set state to loading
        _state.update { oldState ->
            oldState.copy(
                isLoading = true,
                users = emptyList(),
                isError = false
            )
        }

        viewModelScope.launch {
            try {
                val latestUsersFromNetwork = gitHubRepository.searchUsers(search)
                latestUsersFromNetwork.collect {
                    usersList = it.items
                }
                _state.update { oldState ->

                    oldState.copy(
                        isLoading = false,
                        users = usersList!!,
                        isError = false
                    )

                }

            } catch (e: Exception) {
                _state.update { oldState ->
                    e.message?.let {
                        oldState.copy(
                            isLoading = false,
                            users = emptyList(),
                            isError = true,
                            errorMessage = it
                        )
                    }!!
                }
            }

        }
    }
}
