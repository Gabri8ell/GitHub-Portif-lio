package app.mypc.portifolio_git_hub.repositorie.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.mypc.portifolio_git_hub.repositorie.domain.ListUserRepositoriesUseCase
import androidx.lifecycle.MutableLiveData
import app.mypc.portifolio_git_hub.repositorie.model.Repo
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch


class MainViewModel (
    private val listUserRepositoriesUseCase: ListUserRepositoriesUseCase
): ViewModel()  {

    private val _repos = MutableLiveData<State>()
    val repos: LiveData<State> = _repos

    fun getepoList(user: String){
        viewModelScope.launch {
            listUserRepositoriesUseCase(user)
                .onStart {
                    _repos.postValue(State.Loading)
                }
                .catch {
                    _repos.postValue(State.Error(it))
                }
                .collect {
                    _repos.postValue(State.Sucess(it))
                }
        }
    }

    sealed class State{
        object Loading : State()
        data class  Sucess(val list: List<Repo>):State()
        data class  Error(val error: Throwable): State()
    }
}