package com.example.mybusschedual.ui.item


import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.mybusschedual.AppModelProvider
import com.example.mybusschedual.data.Station
import com.example.mybusschedual.navigationData.NavRouteData
import androidx.compose.runtime.getValue
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(
    navController: NavHostController
){
    val viewModel : MainScreenViewModel = viewModel(factory = AppModelProvider.Factory)

    val showState by viewModel.showClass.collectAsState()

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


            InventoryList(showState.allStation)
//           ItemHolder(navController)
//            Spacer(
//                modifier = Modifier.height(8.dp)
//            )
//            ItemHolder(navController)
//            Spacer(
//                modifier = Modifier.height(8.dp)
//            )
//            ItemHolder(navController)

        }
    }

    }

}
@Composable
private fun InventoryList(
    itemList: List<Station>,
//    onItemClick: (Item) -> Unit,
//    contentPadding: PaddingValues,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
//        contentPadding = contentPadding
    ) {
        items(items = itemList, key = { it.id }) { item ->
            ItemHolder(item = item,
//                modifier = Modifier
//                    .padding(dimensionResource(id = R.dimen.padding_small))
//                    .clickable { onItemClick(item) }
            )
        }
    }
}

@Composable
fun ItemHolder(
    //navController: NavHostController,
    item: Station
){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
            .height(40.dp)
            .background(color = Color.Cyan)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text=" ${item.busName}"
        )

        Text(
            text=" ${item.departureTime}"
        )

        Text(
            text=" ${item.arrivalTime}"
        )
    }
}