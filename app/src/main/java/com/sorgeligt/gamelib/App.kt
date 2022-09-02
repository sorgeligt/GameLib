package com.sorgeligt.gamelib

import android.app.Application
import com.sorgeligt.gamelib.di.DaggerAppComponent

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        initDi()
    }

    private fun initDi() {
        DI.appComponent = DaggerAppComponent.builder()
            .appComponent(this)
            .build()
    }
}
