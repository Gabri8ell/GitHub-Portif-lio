package app.mypc.portifolio_git_hub.repositorie

import android.app.Application
import app.mypc.portifolio_git_hub.repositorie.data.ui.DataModule
import app.mypc.portifolio_git_hub.repositorie.domain.di.DomainModule
import app.mypc.portifolio_git_hub.repositorie.presentation.di.PresentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
        }

        DataModule.load()
        DomainModule.load()
        PresentationModule.load()
    }
}