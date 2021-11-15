package com.example.tema_ma

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import domain.dish
import domain.result_type


@Composable
fun EditView(navController: NavController,ID: Long?,DVC: DishViewModel)
{
    var SelectedDish = DVC.get(ID)
    val scrollState = rememberScrollState()
    var ingText by remember {
        mutableStateOf("${SelectedDish.Ingredients}")
    }
    var drop_value  by remember {
        mutableStateOf(SelectedDish.Results)
    }
    var recText by remember {
        mutableStateOf("${SelectedDish.Recipe}")
    }

    var name_text by remember{
        mutableStateOf("${SelectedDish.Name}")
    }
    var expanded by remember{
        mutableStateOf(false)
    }

    var Result_List = result_type.values()
    Column() {
        Row(
            Modifier
                .fillMaxHeight(0.15f)
                .fillMaxWidth()
                .background(Color(0xff3c70ba))
        ) {
            Card(modifier = Modifier
                .height(100.dp)
                .width(100.dp)) {
                Image(modifier = Modifier.fillMaxWidth(),painter = painterResource(id = SelectedDish.Image), contentDescription = "")
            }
            TextField(value = name_text,onValueChange = {name_text = it})
        }
        Row(
            Modifier
                .fillMaxHeight(0.9f)
                .fillMaxWidth()
                .background(Color.Cyan)
        ) {
            Column(
                modifier = Modifier.verticalScroll(scrollState)
            ) {
                Card(modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth(),backgroundColor = Color.LightGray) {
                    TextField(value = ingText,onValueChange = {ingText = it})
                }
                Card(modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth(),backgroundColor = Color.LightGray) {
                    TextField(value = recText,onValueChange = {recText = it})
                }
                Row(Modifier.clickable { expanded = !expanded }){
                    Text(text = drop_value.name)
                    Icon(imageVector = Icons.Filled.KeyboardArrowUp, contentDescription = "")
                    DropdownMenu(expanded = expanded, onDismissRequest = {expanded = false}) {
                        Result_List.forEach { state-> DropdownMenuItem(onClick = { expanded = false
                        drop_value = state }) {
                            Text(state.name)
                        } }

                }
                }

            }

        }

        Row(modifier = Modifier.background(Color(0xff3c70ba)))
        {
            Text(modifier = Modifier.clickable { navController.navigate(Screen.MainList.route) }.fillMaxHeight().fillMaxWidth(0.5f),text = "Back")
            Text(modifier = Modifier.clickable { DVC.update(ID,dish(ID,name_text,ingText,recText,drop_value,SelectedDish.Image)) }.fillMaxHeight().fillMaxWidth(),text = "Apply")
        }
    }
}