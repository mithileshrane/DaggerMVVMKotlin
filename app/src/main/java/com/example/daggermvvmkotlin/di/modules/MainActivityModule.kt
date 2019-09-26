package com.example.daggermvvmkotlin.di.modules

import com.example.daggermvvmkotlin.MainActivity
import com.example.daggermvvmkotlin.di.builders.FragmentBuildersModule
import com.example.daggermvvmkotlin.ui.main.MainViewModel
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.Provides



@Module
abstract class MainActivityModule {

    @ContributesAndroidInjector(modules = [FragmentBuildersModule::class])
    abstract fun contributeMainActivity(): MainActivity
}