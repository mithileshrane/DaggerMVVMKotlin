package com.example.daggermvvmkotlin.api

import com.example.daggermvvmkotlin.responsemodels.Deals
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 *  REST API access points
 */
interface APIService {

    companion object {
        const val ENDPOINT = "https://rebrickable.com/api/v3/"
    }

   /* @GET("lego/themes/")
    suspend fun getThemes(@Query("page") page: Int? = null,
                          @Query("page_size") pageSize: Int? = null,
                          @Query("ordering") order: String? = null): Response<ResultsResponse<LegoTheme>>

    @GET("lego/sets/")
    suspend fun getSets(@Query("page") page: Int? = null,
                        @Query("page_size") pageSize: Int? = null,
                        @Query("theme_id") themeId: Int? = null,
                        @Query("ordering") order: String? = null): Response<ResultsResponse<LegoSet>>

    @GET("lego/sets/{id}/")
    suspend fun getSet(@Path("id") id: String): Response<LegoSet>*/

    @GET("/")
    suspend fun getDeals(): Response<List<Deals>>

}
