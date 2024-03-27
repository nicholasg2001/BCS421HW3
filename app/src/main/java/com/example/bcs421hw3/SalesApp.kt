package com.example.bcs421hw3

import android.app.Application
import androidx.room.Room
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking

class SalesApp: Application() {

    companion object {
        lateinit var salesRepository: SalesRepository
    }

    override fun onCreate(){
        super.onCreate()
        runBlocking(Dispatchers.IO){
            val db = Room.databaseBuilder(
                applicationContext,
                SalesDatabase::class.java, "salesDB"
            ).build()
            salesRepository = SalesRepository(db)
        }
    }


}