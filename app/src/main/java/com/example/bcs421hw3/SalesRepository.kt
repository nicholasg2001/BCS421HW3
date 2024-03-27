package com.example.bcs421hw3

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class SalesRepository(private var salesDatabase: SalesDatabase) {

    suspend fun getAllSales(): List<Sale> {
        return withContext(Dispatchers.IO){
            salesDatabase.saleDao()!!.getAllSales()
        }
    }

    suspend fun insertSale(sale: Sale){
        withContext(Dispatchers.IO){
            salesDatabase.saleDao()!!.insertSale(sale)
        }
    }
}