package com.example.daggermvvmkotlin.responsemodels

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Deals")
data class Deals(
    @PrimaryKey
    @field:SerializedName("id")
    val id: Int,
    @field:SerializedName("name")
    val name: String,
    @field:SerializedName("parent_id")
    val parentId: Int? = null
) {
    override fun toString() = name
}