package com.example.daggermvvmkotlin.di

import android.app.Application
import com.example.daggermvvmkotlin.App
import com.example.daggermvvmkotlin.di.builders.ActivityBuilder
import com.example.daggermvvmkotlin.di.modules.AppModule
import com.example.daggermvvmkotlin.di.modules.MainActivityModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        AppModule::class,
        AndroidInjectionModule::class,
        MainActivityModule::class]
)
interface AppComponent : AndroidInjector<App> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }

}