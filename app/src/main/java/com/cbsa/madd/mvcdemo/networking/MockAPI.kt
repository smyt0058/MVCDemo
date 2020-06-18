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
import retrofit2.http.Path

interface MockAPI {

    @GET("mockArray")
    fun getQuestions() : Observable<MockAPISchema>

    @GET("mockArray/{id}")
    fun getQuestionDetails(@Path("id") id: String) : Observable<MockAPISchemaItem>

}