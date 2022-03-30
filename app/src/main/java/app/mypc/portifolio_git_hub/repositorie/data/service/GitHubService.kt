package app.mypc.portifolio_git_hub.repositorie.data.service

import app.mypc.portifolio_git_hub.repositorie.model.Repo
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubService {
    @GET("user/{user}/repos")
    suspend fun listRespositories(@Path("user")user: String): List<Repo>


}