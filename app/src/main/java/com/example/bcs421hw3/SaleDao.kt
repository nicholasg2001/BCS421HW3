package com.example.bcs421hw3

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface SaleDao {

    @Query("SELECT * FROM sales")
    fun getAllSales(): List<Sale>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSale(sale: Sale)
}