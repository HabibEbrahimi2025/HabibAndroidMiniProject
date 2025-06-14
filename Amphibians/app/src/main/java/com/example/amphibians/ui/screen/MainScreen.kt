package com.example.amphibians.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.amphibians.R
import com.example.amphibians.model.AmphibianPhoto

@OptIn(ExperimentalMaterial3Api::class)
//@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreenFile(){
    val viewModel: AmphibiansViewModel= viewModel()

    Scaffold (
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(R.string.app_name))
                }
            )
        },
//        modifier = Modifier.fillMaxSize(),
        content = {innerPadding->

            Box(
                modifier = Modifier.fillMaxSize().padding(innerPadding),
                contentAlignment = Alignment.TopCenter
            ) {
                when(viewModel.modelState){
                    is AmphibUiState.Error -> Error()
                    is AmphibUiState.Loading -> Loading()
                    is AmphibUiState.Success -> Success((viewModel.modelState as AmphibUiState.Success).photo)
                }
            }
        }
    )
}

@Composable
fun Success(
    photos:List<AmphibianPhoto>

){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
    }


    LazyColumn(
        modifier = Modifier.padding(4.dp),
    ) {
        items(photos) { photo ->
            CardItem(photo)
        }
    }


}

@Composable
fun Error(){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(R.drawable.ic_launcher_foreground),
            contentScale = ContentScale.Crop,
            contentDescription = ""
        )
        Spacer(
            modifier = Modifier.height(30.dp)
        )

        Text(text="I am Error ")
    }
}

@Composable
fun Loading(){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.ic_launcher_background),
            contentScale = ContentScale.Crop,
            contentDescription = ""
        )
        Spacer(
            modifier = Modifier.height(30.dp)
        )

        Text(text="I am loading ")
    }
}


@Composable
fun CardItem(
    imageId: AmphibianPhoto,
){
    Column(
        modifier = Modifier.size(400.dp)
            .border(border= BorderStroke(width = 2.dp, color = Color.Cyan))
            .padding(4.dp),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = imageId.name+"( "+imageId.type+" )")
        Card(
            modifier = Modifier.fillMaxWidth().height(200.dp),
        ){
            AsyncImage(
                model=ImageRequest.Builder(context = LocalContext.current)
                    .data(imageId.img_src)
                    .crossfade(true)
                    .build(),
                contentScale = ContentScale.Crop,
                error = painterResource(R.drawable.ic_launcher_foreground),
                contentDescription = "",
                modifier = Modifier.fillMaxSize()
            )
        }

        Text(text=imageId.description)

    }
}



