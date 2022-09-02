package com.sorgeligt.gamelib.di

import android.content.Context
import com.sorgeligt.gamelib.util.AndroidResourceProvider
import com.sorgeligt.gamelib.util.ResourceProvider
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import javax.inject.Singleton

@Component(modules = [AppModule::class])
@Singleton
interface AppComponent {
    fun resources(): ResourceProvider

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun appComponent(context: Context): Builder

        fun build(): AppComponent
    }
}

@Module
abstract class AppModule {
    @Binds
    @Singleton
    abstract fun bindRecourseProvider(provider: AndroidResourceProvider): ResourceProvider
}
