package com.example.daggermvvmkotlin.di.builders

import com.example.daggermvvmkotlin.ui.main.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeThemeFragment(): MainFragment
}