package com.example.bcs421hw3

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch


class SaleslistViewModel(private var salesRepository: SalesRepository) : ViewModel() {

    private var _salesList = mutableStateOf<List<Sale>>(emptyList())
    val salesList: List<Sale>
        get() = _salesList.value

    init {
        viewModelScope.launch {
            _salesList.value = salesRepository.getAllSales()
        }
    }
}