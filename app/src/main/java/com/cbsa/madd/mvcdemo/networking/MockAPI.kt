package com.cbsa.madd.mvcdemo.networking

import android.content.Context
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import java.util.*
import io.reactivex.Observable

interface MockAPI {

    @GET("mockArray")
    fun getQuestions() : Observable<MockAPISchema>

    companion object {
        fun create(context: Context): MockAPI {

            val client = OkHttpClient().newBuilder().addInterceptor { chain ->
                val request = chain.request()
                    .newBuilder()
                    .build()
                chain.proceed(request)
            }.build()

            val retrofit = Retrofit.Builder()
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://5ee245848b27f3001609481c.mockapi.io/api/v1/")
                .build()
            return retrofit.create(MockAPI::class.java)

        }
    }

}