package com.example.mybusschedual


import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.mybusschedual.navigationData.NavRouteData

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(
    navController: NavHostController
){

    Scaffold(
        topBar = {},
        bottomBar = {}
    ) {


    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        Spacer(
            modifier = Modifier.height(30.dp)
        )
        Button(
            onClick = {navController.navigate(NavRouteData.AddingPage.route)},
            modifier = Modifier.align(Alignment.End)

        ) {
            Text(
                text="New Data"
            )
        }

        Spacer(
            modifier = Modifier.height(30.dp)
        )
        Column(
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {



           ItemHolder(navController)
            Spacer(
                modifier = Modifier.height(8.dp)
            )
            ItemHolder(navController)
            Spacer(
                modifier = Modifier.height(8.dp)
            )
            ItemHolder(navController)

        }
    }

    }

}

@Composable
fun ItemHolder(
    navController: NavHostController
){
    Row(
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier.fillMaxWidth()
            .height(40.dp)
            .background(color = Color.Cyan)
            .padding(8.dp)
    ) {
        Text(
            text="Qala Now"
        )
    }
}