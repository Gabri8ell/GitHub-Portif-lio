package app.mypc.portifolio_git_hub.repositorie

import app.mypc.portifolio_git_hub.repositorie.data.service.GitHubService
import kotlinx.coroutines.flow.flow

class RepoRepositoriesImpl (private val service: GitHubService): RepoRepositories  {
    override suspend fun listaRepositories(user: String) = flow {
        val repolist = service.listRespositories(user)
        emit(repolist)
    }

}
