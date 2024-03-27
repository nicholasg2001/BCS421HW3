package com.example.bcs421hw3

import androidx.compose.runtime.Composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController

@Composable
fun RootScreen(){
    val navController = rememberNavController()
    var selectedItemIndex by rememberSaveable { mutableIntStateOf(0) }

    val navItemsList = listOf(
        NavItem(
            title="Home",
            iconSelected = Icons.Filled.Home,
            iconUnselected = Icons.Outlined.Home,
            route="SaleslistScreen",
        ),
        NavItem(
            title="Add",
            iconSelected = Icons.Filled.Add,
            iconUnselected = Icons.Outlined.Add,
            route="AddSaleScreen",
        ),
    )

    Scaffold(
        bottomBar = {
            NavigationBar {
                navItemsList.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = (selectedItemIndex == index),
                        onClick = { selectedItemIndex = index
                            navController.navigate(item.route){
                                popUpTo(navController.graph.startDestinationId){
                                    inclusive = true
                                }
                            }
                        },
                        label = { Text(text = item.title) },
                        icon = {
                            Icon(
                                contentDescription = item.title,
                                imageVector =
                                if (index == selectedItemIndex) item.iconSelected
                                else item.iconUnselected
                            )
                        }
                    )
                }
            }
        }
    ) {
            padding ->
        Column(
            modifier = Modifier.padding(padding)
        ) {
            NavHost(navController)
        }
    }
}