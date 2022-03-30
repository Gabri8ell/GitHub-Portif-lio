package app.mypc.portifolio_git_hub.repositorie.domain

import app.mypc.portifolio_git_hub.repositorie.RepoRepositories
import app.mypc.portifolio_git_hub.repositorie.core.UseCase
import app.mypc.portifolio_git_hub.repositorie.model.Repo
import kotlinx.coroutines.flow.Flow

class ListUserRepositoriesUseCase (
    private val repository: RepoRepositories
): UseCase<String, List<Repo>>() {

    override suspend fun execute(param: String): Flow<List<Repo>> {
        return repository.listaRepositories(param)
    }

}