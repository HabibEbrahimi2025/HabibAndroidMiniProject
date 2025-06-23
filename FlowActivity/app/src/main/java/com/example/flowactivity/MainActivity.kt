package com.example.flowactivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.flowactivity.data.ViewModelPage
import com.example.flowactivity.ui.theme.FlowActivityTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.fold
import kotlinx.coroutines.flow.reduce
import kotlinx.coroutines.flow.zip

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FlowActivityTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SetupMainScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun SetupMainScreen(
    viewModel: ViewModelPage= viewModel(),
    modifier: Modifier = Modifier
) {
    MainScreen(
        viewModel.myflow,
       // viewModel.asFlow1
        viewModel
    )
}

@Composable
fun MainScreen(
    flow1:Flow<Int>,
    viewModel: ViewModelPage
   // flow2: Flow<String>
){
   // val count by flow1.collectAsState("Current value ")

    var count by remember { mutableStateOf(0) }
    LaunchedEffect(Unit) {

//        try {
//            flow1.buffer()
//                .collect {
//                delay(1000)
//                count = it
//            }
//
//        }



//        try{
//            flow1.reduce { a,b->
//                count=a
//                a+b
//            }
//        }


//        try{
//            flow1.fold(100) {accum, value->
//                count=accum
//                accum+value
//
//            }
//        }



//        try{
//            flow1.combine(flow2){value1, value2->
//                "Value1 is $value1 and value2 is $value2"
//            }.collect { count=it }
//        }



        try{
            flow1.flatMapConcat { viewModel.doubleIt(it) }
                .collect { count=it }
        }
        finally {
            count=0
        }
    }


    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = " $count ",
            style = TextStyle(fontSize = 46.sp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FlowActivityTheme {
       SetupMainScreen()
    }
}