package com.example.tema_ma

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import domain.dish
import domain.result_type

@Composable
fun AddView(navController: NavController, DVM: DishViewModel) {
    val scrollState = rememberScrollState()
    var ingText by remember {
        mutableStateOf("")
    }
    var drop_value by remember {
        mutableStateOf(result_type.OK)
    }
    var recText by remember {
        mutableStateOf("")
    }

    var name_text by remember {
        mutableStateOf("")
    }
    var expanded by remember {
        mutableStateOf(false)
    }
    var Result_List = result_type.values()
    val openDialog = remember { mutableStateOf(false) }


    Column()
    {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.07f)
                .background(Color(0xff3c70ba))
        ) {
            TextField(modifier = Modifier
                .fillMaxSize()
                .fillMaxHeight(), value = name_text, onValueChange = { name_text = it },
            )
        }
        Column(modifier = Modifier.fillMaxHeight(0.9f).verticalScroll(scrollState)) {


            Card(
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth(), backgroundColor = Color.LightGray
            ) {
                TextField(value = ingText, onValueChange = { ingText = it })
            }
            Card(
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth(), backgroundColor = Color.LightGray
            ) {
                TextField(value = recText, onValueChange = { recText = it })
            }
            Row(Modifier.clickable { expanded = !expanded }) {
                Text(text = drop_value.name)
                Icon(imageVector = Icons.Filled.KeyboardArrowUp, contentDescription = "")
                DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                    Result_List.forEach { state ->
                        DropdownMenuItem(onClick = {
                            expanded = false
                            drop_value = state
                        }) {
                            Text(state.name)
                        }
                    }
                }

            }
        }
        Row(modifier = Modifier.fillMaxHeight().fillMaxWidth().background(Color(0xff3c70ba))) {
            Text(modifier = Modifier.clickable { navController.navigate(Screen.MainList.route) }.fillMaxHeight().fillMaxWidth(0.5f),text = "Back")
            Text(modifier = Modifier.clickable {
                if (name_text.equals("") || ingText.equals("") || recText.equals(""))
                {
                    openDialog.value = true

                }
                else {
                    DVM.add(
                        dish(
                            DVM.get_unsused_id(),
                            name_text,
                            ingText,
                            recText,
                            drop_value,
                            R.drawable.gulas
                        )
                    )
                    navController.navigate(Screen.MainList.route)
                }
            }.fillMaxHeight().fillMaxWidth(),text = "Add")
        }
    }
    if (openDialog.value==true) {
        AlertDialog(

            onDismissRequest = {
                openDialog.value = false
            },
            text = {
                Text(
                    "Invalid Data!",
                    fontSize = 16.sp
                )
            },
            dismissButton = {},
            confirmButton = {},
            backgroundColor = Color.White,
            contentColor = Color.Black
        )
    }

}
