package com.example.daggermvvmkotlin.di.builders

import com.example.daggermvvmkotlin.MainActivity
import com.example.daggermvvmkotlin.di.modules.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
public abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun contributeMainActivity(): MainActivity

}