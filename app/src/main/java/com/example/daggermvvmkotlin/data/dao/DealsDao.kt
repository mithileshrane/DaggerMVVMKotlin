package com.example.daggermvvmkotlin.data.dao

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.daggermvvmkotlin.responsemodels.Deals

/**
 * The Data Access Object for the LegoSet class.
 */
@Dao
interface DealsDao {

    @Query("SELECT * FROM Deals WHERE parentId = :themeId ORDER BY name DESC")
    fun getLegoSets(themeId: Int): LiveData<List<Deals>>

    @Query("SELECT * FROM Deals WHERE parentId = :themeId ORDER BY name DESC")
    fun getPagedLegoSetsByTheme(themeId: Int): DataSource.Factory<Int, Deals>

    @Query("SELECT * FROM Deals ORDER BY name DESC")
    fun getPagedLegoSets(): DataSource.Factory<Int, Deals>

    @Query("SELECT * FROM Deals WHERE id = :id")
    fun getLegoSet(id: String): LiveData<Deals>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(legoSets: List<Deals>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(legoSet: Deals)
}
