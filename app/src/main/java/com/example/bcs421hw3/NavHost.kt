package com.example.bcs421hw3

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavHost(navController: NavHostController) {

    NavHost(navController = navController, startDestination = "SaleslistScreen") {
        composable(route = "SaleslistScreen") {
            SaleslistScreen()
        }
        composable(route = "AddSaleScreen") {
            AddSaleScreen()
        }
    }
}