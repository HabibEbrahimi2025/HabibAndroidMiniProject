package com.example.marsphotos.network

import com.example.marsphotos.model.MarsPhoto
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
//import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private  const val BASE_URL=
    "https://android-kotlin-fun-mars-server.appspot.com"
    //"https://jsonplaceholder.typicode.com/"

//private val retrofit=Retrofit.Builder()
//    .addConverterFactory(ScalarsConverterFactory.create())
//    .baseUrl((BASE_URL))
//    .build()


private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)  // ✅ must end with "/"
    .addConverterFactory(GsonConverterFactory.create())  // or MoshiConverterFactory.create()
    .build()


interface MarsApiService{
    @GET("photos")
    suspend fun getPhotos(): Response<List<MarsPhoto>>
}

object MarsApi{
    val retrofitService:MarsApiService by lazy {
        retrofit.create(MarsApiService::class.java)
    }

   // val apiService: ApiService = retrofit.create(ApiService::class.java)
}