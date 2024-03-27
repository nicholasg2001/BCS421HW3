package com.example.bcs421hw3

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun SaleslistScreen() {

    val viewModel = viewModel { SaleslistViewModel(SalesApp.salesRepository) }
    val salesList: List<Sale> = viewModel.salesList

    Surface(
        modifier = Modifier.padding(20.dp),
        shape = RoundedCornerShape(10.dp),
        shadowElevation = 30.dp,
    ) {
        Column {
            Text(
                text = "Sales List",
                modifier = Modifier.padding(10.dp),
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            LazyColumn {
                items(salesList){sale ->
                    Surface(
                        modifier = Modifier
                            .padding(vertical = 5.dp, horizontal = 15.dp)
                            .fillMaxWidth(),
                        shape = RoundedCornerShape(10.dp),
                        shadowElevation = 10.dp,
                    ) {
                        Column {
                            Text(
                                text = sale.name,
                                fontSize = 25.sp,
                                color = Color.Magenta,
                                style = MaterialTheme.typography.bodyLarge,
                            )
                            Text(
                                text = sale.amount.toString(),
                                fontSize = 20.sp
                            )
                        }
                    }
                }
            }
        }
    }
}