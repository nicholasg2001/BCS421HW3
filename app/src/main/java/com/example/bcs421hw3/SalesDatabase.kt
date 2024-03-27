package com.example.bcs421hw3

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Sale::class], version = 1)
abstract class SalesDatabase : RoomDatabase() {
    abstract fun saleDao() : SaleDao?
}