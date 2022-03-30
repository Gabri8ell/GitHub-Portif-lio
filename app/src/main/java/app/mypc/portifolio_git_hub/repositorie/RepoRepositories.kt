package app.mypc.portifolio_git_hub.repositorie

import app.mypc.portifolio_git_hub.repositorie.model.Repo
import kotlinx.coroutines.flow.Flow

interface RepoRepositories {
    suspend fun listaRepositories(user: String): Flow<List<Repo>>
}