package com.example.bcs421hw3

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sales")
data class Sale(
    @PrimaryKey val name:String,
    @ColumnInfo(name = "amount") val amount:Double,
)