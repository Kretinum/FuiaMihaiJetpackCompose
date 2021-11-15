package com.example.tema_ma

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tema_ma.ui.theme.Tema_maTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.example.tema_ma.ui.theme.LoginView
import domain.dish
import domain.result_type

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {


            var dish_1 = dish(0,"Guoulash","Cartofi\nCeapa\nMorcovi","Se amesteca ingredientele in ceaus",
                result_type.OK,R.drawable.gulas)
            var dish_2 = dish(1,"Ciorba","Cartofi\nCeapa\nMorcovi","Se amesteca ingredientele in ceaus",
                result_type.OK,R.drawable.cirb)
            var dish_3 = dish(2,"Orez","Cartofi\nCeapa\nMorcovi","Se amesteca ingredientele in ceaus\nSi amesteca\nSi amesteca\nSi amesteca\nSi Amesteca\nSi amesteca\nSi amesteca\n" +
                    "Si amesteca\n" +
                    "Si amesteca\n" +
                    "Si amesteca\n" +
                    "Si Amesteca\n" +
                    "Si amesteca\n" +
                    "Si amesteca\n" +
                    "Si amesteca\n" +
                    "Si amesteca\n" +
                    "Si amesteca\n" +
                    "Si Amesteca\n" +
                    "Si amesteca\n" +
                    "Si amesteca\n" +
                    "Si amesteca\n" +
                    "Si amesteca\n" +
                    "Si amesteca\n" +
                    "Si Amesteca\n" +
                    "Si amesteca\n" +
                    "Si amesteca\n" +
                    "Si amesteca\n" +
                    "Si amesteca\n" +
                    "Si amesteca\n" +
                    "Si Amesteca\n" +
                    "Si amesteca\n" +
                    "Si amesteca",
                result_type.OK,R.drawable.orez)


            val DVM = DishViewModel()
            DVM.add(dish_1)
            DVM.add(dish_2)
            DVM.add(dish_3)
            Navigation(DVM)
        }
    }

}





