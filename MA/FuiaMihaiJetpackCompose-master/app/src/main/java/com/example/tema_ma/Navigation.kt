package com.example.tema_ma

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import domain.dish

@RequiresApi(Build.VERSION_CODES.N)
@ExperimentalMaterialApi
@Composable
fun Navigation(vm : DishViewModel){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainList.route){
        composable(route = Screen.MainList.route)
        {
            MainList(navController = navController,DVM = vm)
        }
        composable(route = Screen.EditView.route + "/{ID}",arguments = listOf(navArgument("ID"){
            type = NavType.LongType
            defaultValue = 0
            nullable = false
        }))
        {
            entrry -> EditView(navController = navController, ID = entrry.arguments?.getLong("ID"), DVC = vm)
        }
        composable(route = Screen.AddView.route)
        {
            AddView(navController = navController,DVM = vm)
        }
    }
}

