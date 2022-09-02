package com.sorgeligt.gamelib.ui.viewmodel.mainscreen

import androidx.lifecycle.ViewModel
import com.sorgeligt.gamelib.DI
import com.sorgeligt.gamelib.di.ScreenScope
import com.sorgeligt.gamelib.di.ViewModelFactory
import com.sorgeligt.gamelib.di.ViewModelKey
import com.sorgeligt.gamelib.util.ResourceProvider
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.multibindings.IntoMap

@Component(modules = [MainScreenModule::class])
@ScreenScope
interface MainScreenComponent {

    fun viewModelFactory(): ViewModelFactory

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun resources(resourceProvider: ResourceProvider): Builder

        fun build(): MainScreenComponent
    }

    companion object {
        fun create() = with(DI.appComponent) {
            DaggerMainScreenComponent.builder()
                .resources(resources())
                .build()
        }
    }
}

@Module
abstract class MainScreenModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainScreenViewModel::class)
    abstract fun mainScreenViewModel(viewModel: MainScreenViewModel): ViewModel
}
