package com.example.androidengrtest.repository

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
class RepositoryViewModel @Inject constructor(private val gitHubRepository: GitHubRepository) :
    ViewModel() {


    private val _state = MutableStateFlow(RepositoryViewState())
    val state: StateFlow<RepositoryViewState> = _state.asStateFlow()

    private var repositoryList: List<RepositoryItem>? = null

    fun searchRepositories(search: String) {

        //Set state to loading
        _state.update { oldState ->
            oldState.copy(
                isLoading = true,
                repositories = emptyList(),
                isError = false,
                hasSearched = true
            )
        }

        viewModelScope.launch {
            try {
                val latestMoviesFromNetwork = gitHubRepository.searchRepositories(search)
                latestMoviesFromNetwork.collect {
                    repositoryList = it.items
                }
                _state.update { oldState ->

                    oldState.copy(
                        isLoading = false,
                        repositories = repositoryList!!,
                        isError = false,
                        hasSearched = true
                    )

                }

            } catch (e: Exception) {
                _state.update { oldState ->
                    e.message?.let {
                        oldState.copy(
                            isLoading = false,
                            repositories = emptyList(),
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

