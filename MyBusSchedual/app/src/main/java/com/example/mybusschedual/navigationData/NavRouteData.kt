package com.example.mybusschedual.navigationData

sealed class NavRouteData(val route:String) {
    object MainPage: NavRouteData("mainpae")
    object AddingPage: NavRouteData("addingpage")
    object DetailePage: NavRouteData("detailpage")

}