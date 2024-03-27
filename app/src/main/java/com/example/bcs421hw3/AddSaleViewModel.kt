package com.example.bcs421hw3

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddSaleViewModel(private var salesRepository: SalesRepository) : ViewModel() {

    fun insertSale(sale: Sale){
        viewModelScope.launch(Dispatchers.IO) {
            salesRepository.insertSale(sale)
        }
    }
}