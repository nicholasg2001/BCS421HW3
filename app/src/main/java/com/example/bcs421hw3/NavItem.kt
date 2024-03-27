package com.example.bcs421hw3

import androidx.compose.ui.graphics.vector.ImageVector

data class NavItem (
    val title:String,
    val iconSelected: ImageVector,
    val iconUnselected: ImageVector,
    val route:String,
)