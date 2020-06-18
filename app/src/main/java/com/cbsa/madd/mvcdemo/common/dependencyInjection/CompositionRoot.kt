package com.cbsa.madd.mvcdemo.common.dependencyInjection

import android.content.Context
import com.cbsa.madd.mvcdemo.networking.MockAPI
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class CompositionRoot {

    private var mRetrofit: Retrofit? = null

    fun getMockApi(context: Context): MockAPI {
        return getRetrofit(context).create(MockAPI::class.java)
    }

    private fun getRetrofit(context: Context): Retrofit {

        if(mRetrofit == null) {
            val client = OkHttpClient().newBuilder().addInterceptor { chain ->
                val request = chain.request()
                    .newBuilder()
                    .build()
                chain.proceed(request)
            }.build()

            mRetrofit = Retrofit.Builder()
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://5ee245848b27f3001609481c.mockapi.io/api/v1/")
                .build()
        }


        return mRetrofit!!
    }

}