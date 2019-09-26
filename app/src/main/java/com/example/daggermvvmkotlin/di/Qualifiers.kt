package com.example.daggermvvmkotlin.di

import javax.inject.Qualifier

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class APICall

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class CoroutineScropeIO