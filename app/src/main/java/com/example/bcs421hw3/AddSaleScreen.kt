package com.example.bcs421hw3

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.launch

@Composable
fun AddSaleScreen() {

    val viewModel = viewModel { AddSaleViewModel(SalesApp.salesRepository) }

    var name by remember { mutableStateOf("") }
    var amount by remember { mutableStateOf("")}

    Surface(
        modifier = Modifier
            .padding(20.dp)
            .wrapContentSize(Alignment.TopCenter),
        shape = RoundedCornerShape(10.dp),
        shadowElevation = 30.dp,
    ) {
        Column(
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "Add Sale",
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth(),
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            TextField(value = name,
                onValueChange = { name = it},
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth(),
                placeholder = { Text("Name") }
            )
            TextField(value = amount,
                onValueChange = { amount = it},
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth(),
                placeholder = { Text("Amount") }
            )
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                onClick = {
                    val sale = Sale(name = name, amount = amount.toDouble());
                    viewModel.insertSale(sale)
                    name = ""
                    amount = ""
                }
            ) {
                Text(text = "Add")
            }
        }
    }
}