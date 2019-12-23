package com.example.android_4a.ui.data

import com.example.android_4a.ui.data.network.response.CurrentWeatherResponse
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


const val API_KEY = "122631b5b04a11378483408dc551501f"

// http://api.weatherstack.com/current?access_key=122631b5b04a11378483408dc551501f&query=New%20York&lang=en


interface WeatherstackWeatherApiService {

    @GET("current")
    fun getCurrentWeather(
        @Query("query") location : String,
        @Query("lang") languageCode: String = "en"

    ) : Deferred<CurrentWeatherResponse>

    companion object{
        operator fun invoke (): WeatherstackWeatherApiService{
            val requestInterceptor = Interceptor{chain ->
                val url = chain.request()
                    .url()
                    .newBuilder()
                    .addQueryParameter("access_key", API_KEY)
                    .build()
                val request = chain.request()
                    .newBuilder()
                    .url(url)
                    .build()

                return@Interceptor chain.proceed(request)
            }

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .build()

            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("http://api.weatherstack.com/")
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(WeatherstackWeatherApiService::class.java)
        }
    }
}