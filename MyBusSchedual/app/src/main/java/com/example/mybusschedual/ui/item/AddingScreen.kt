package com.example.mybusschedual.ui.item

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.mybusschedual.AppModelProvider
import java.nio.file.WatchEvent

@Composable
fun AddingScreen(
    navController: NavHostController
){

    val viewModel: AddingScreenViewModel= viewModel(factory = AppModelProvider.Factory)
    val setBusDetails: BusDetails= BusDetails()

    var name by remember { mutableStateOf("") }
    var departure by remember { mutableStateOf("") }
    var arrival by remember { mutableStateOf("") }

    Box(
        contentAlignment = Alignment.TopStart,
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ){
        Column (
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.padding(8.dp)
        ){
            TextField(
                value = name,
                label = {
                    Text(
                        text="Bus Station "
                    )
                },
                onValueChange = {name=it}
            )


            TextField(
                value = departure,
                label = {
                    Text(
                        text="Departure Time "
                    )
                },
                onValueChange = {departure=it}
            )


            TextField(
                value = arrival,
                label = {
                    Text(
                        text="Arrival Time "
                    )
                },
                onValueChange = {arrival=it}
            )


            Button(
                onClick = {
//                    setBusDetails.busId=1
                    setBusDetails.busStationName=name
                    setBusDetails.busDeparture=departure
                    setBusDetails.basArrival=arrival
                    viewModel.updateAllState(setBusDetails)

                    viewModel.displayData()

                }
            ) {
                Text(
                    text="Save",
                    fontSize = 24.sp
                )
            }

        }
    }
}