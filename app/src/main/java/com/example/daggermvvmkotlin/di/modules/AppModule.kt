package com.example.daggermvvmkotlin.di.modules

import android.app.Application
import com.example.daggermvvmkotlin.BuildConfig
import com.example.daggermvvmkotlin.api.APIService
import com.example.daggermvvmkotlin.api.dataSource.DealsRemoteDataSource
import com.example.daggermvvmkotlin.data.AppDatabase
import com.example.daggermvvmkotlin.di.APICall
import com.example.daggermvvmkotlin.di.CoroutineScropeIO
import com.example.daggermvvmkotlin.di.viewmodel.ViewModelModule
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class, CoreDataModule::class])
class AppModule {

    @Singleton
    @Provides
    fun provideAPIService(@APICall okhttpClient: OkHttpClient,
                           converterFactory: GsonConverterFactory
    ) = provideService(okhttpClient, converterFactory, APIService::class.java)

    @Singleton
    @Provides
    fun provideDealsRemoteDataSource(APIService: APIService)
            = DealsRemoteDataSource(APIService)


  /*  @APICall
    @Provides
    fun providePrivateOkHttpClient(
        upstreamClient: OkHttpClient
    ): OkHttpClient {
        return upstreamClient.newBuilder()
            .addInterceptor(AuthInterceptor(BuildConfig.API_DEVELOPER_TOKEN)).build()
    }*/

    @Singleton
    @Provides
    fun provideDb(app: Application) = AppDatabase.getInstance(app)

    @Singleton
    @Provides
    fun provideDealsDao(db: AppDatabase) = db.dealsDao()

    @CoroutineScropeIO
    @Provides
    fun provideCoroutineScopeIO() = CoroutineScope(Dispatchers.IO)


    private fun createRetrofit(
        okhttpClient: OkHttpClient,
        converterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(APIService.ENDPOINT)
            .client(okhttpClient)
            .addConverterFactory(converterFactory)
            .build()
    }

    private fun <T> provideService(okhttpClient: OkHttpClient,
                                   converterFactory: GsonConverterFactory, clazz: Class<T>): T {
        return createRetrofit(okhttpClient, converterFactory).create(clazz)
    }
}