package app.mypc.portifolio_git_hub.repositorie.data.ui

import android.util.Log
import app.mypc.portifolio_git_hub.repositorie.RepoRepositories
import app.mypc.portifolio_git_hub.repositorie.RepoRepositoriesImpl
import app.mypc.portifolio_git_hub.repositorie.data.service.GitHubService
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object DataModule {
    private  const val OK_HTTP = "OKHttp"

    fun load(){
        loadKoinModules(netwokModules() + repositoriesModule())
    }

    private fun netwokModules(): Module{
        return module{
            single {
                val interceptor = HttpLoggingInterceptor{
                    Log.e(OK_HTTP, it)
                }
                interceptor.level = HttpLoggingInterceptor.Level.BODY

                OkHttpClient.Builder().addInterceptor(interceptor).build()
            }

            single {
                GsonConverterFactory.create(GsonBuilder().create())
            }

            single {
                createService<GitHubService>(get(), get())
            }
        }
    }

    private fun repositoriesModule(): Module{
        return module {
            single<RepoRepositories> { RepoRepositoriesImpl(get())}
        }
    }

    private  inline fun <reified T>  createService(get: Any, get1: Any): T{
        return  Retrofit.Builder().baseUrl("https://api.github.com/")
            .build().create(T::class.java)
    }
}
