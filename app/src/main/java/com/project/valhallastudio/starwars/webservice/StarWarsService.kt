package com.project.valhallastudio.starwars.webservice

import android.os.Build
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * @author kemosabe_x
 * Created on 5/30/20
 */

class StarWarsService {

    companion object{
        @JvmStatic
         val API_URL: String = "https://swapi.dev/api/"

        private  val logger : HttpLoggingInterceptor  = HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }

        private val okHttp: OkHttpClient.Builder = OkHttpClient.Builder().apply {
            readTimeout(15, TimeUnit.SECONDS)
            addInterceptor(
                object: Interceptor{
                    override fun intercept(chain: Interceptor.Chain): Response {
                        return chain.proceed(
                            chain.request()
                                .newBuilder()
                                .build()
                        )
                    }
                }
            )
            addInterceptor(logger)
        }

        val retrofit = Retrofit.Builder().apply {
            baseUrl(API_URL)
            addConverterFactory(GsonConverterFactory.create())
            client(okHttp.build())
        }.build()


        fun getInstance (): StarWarsEndpoints {
            return  retrofit.create(StarWarsEndpoints::class.java)
        }
    }

}