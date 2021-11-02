package com.example.tema_ma


import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import domain.dish
import domain.result_type
import java.util.function.Predicate
import kotlin.math.absoluteValue
import androidx.navigation.NavController as NavController1

@RequiresApi(Build.VERSION_CODES.N)
@ExperimentalMaterialApi
@Composable
fun MainList(navController: NavController1,DVM: DishViewModel)
{
    val scrollState = rememberScrollState()

    val openDialog = remember { mutableStateOf(false) }
    val do_delete = remember { mutableStateOf(false) }

    var dishes = remember {
        SnapshotStateList<dish>()
    }
    var delete_taget = remember{
        mutableStateOf(0)
    }
    dishes = DVM.get_list()
    Column {
        LazyColumn(modifier = Modifier.fillMaxHeight(0.9f)) {
            items(
                items = dishes
            )
            {


                Card(modifier = Modifier
                    .padding(5.dp)
                    .height((120).dp)
                    .fillMaxWidth(), backgroundColor = Color(0xff3c70ba),
                    onClick = {
                        navController.navigate(Screen.EditView.withArgs(it.ID))
                    }

                )
                {


                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Card(
                            modifier = Modifier
                                .height(100.dp)
                                .width(100.dp)
                        ) {
                            Image(
                                modifier = Modifier.fillMaxWidth(),
                                painter = painterResource(id = it.Image),
                                contentDescription = ""
                            )
                        }

                        Text(text = "${it.Name}")
                        Button(modifier = Modifier
                            .height(60.dp)
                            .width(60.dp),
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xffc92020)),
                            onClick = {
                                openDialog.value = true
                                delete_taget.value = it.ID!!.toInt()

                                //dishes.removeAt(it.ID.toInt())

                            }) {
                            Text(text = "X", color = Color.White)
                        }



                        if (openDialog.value) {
                            AlertDialog(

                                onDismissRequest = {
                                    openDialog.value = true
                                },
                                text = {
                                    Text(
                                        "Are you sure you want to delete this item? ${it.ID}",
                                        fontSize = 16.sp
                                    )
                                },
                                confirmButton = {
                                    TextButton(
                                        onClick = {
                                            openDialog.value = false
                                            DVM.remove_id(delete_taget.value.toLong())
                                        }) {
                                        Text("Yes", style = TextStyle(color = Color.Black))
                                    }
                                },
                                dismissButton = {
                                    TextButton(
                                        onClick = {
                                            openDialog.value = false
                                        }) {
                                        Text("No", style = TextStyle(color = Color.Black))
                                    }
                                },
                                backgroundColor = Color.White,
                                contentColor = Color.Black
                            )
                        }


                    }

                }


            }



        }
        Row(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(Color(0xff3c70ba)))
        {
            Button(modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),onClick = { navController.navigate(Screen.AddView.route) }) {
                    Text(text = "+")
            }
        }
    }

    }













