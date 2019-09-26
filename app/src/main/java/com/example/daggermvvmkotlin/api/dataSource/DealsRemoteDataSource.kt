package com.example.daggermvvmkotlin.api.dataSource

import com.example.daggermvvmkotlin.BaseDataSource
import com.example.daggermvvmkotlin.api.APIService
import javax.inject.Inject


/**
 * Works with the Lego API to get data.
 */
class DealsRemoteDataSource @Inject constructor(private val service: APIService) : BaseDataSource() {

    suspend fun fetchDeals()
            = getResult { service.getDeals() }

}
