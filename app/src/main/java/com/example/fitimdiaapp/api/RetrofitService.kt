package com.example.geekssampleapp.api

import com.example.fitimdiaapp.BuildConfig
import com.example.fitimdiaapp.api.APITags
import com.example.fitimdiaapp.api.request.GenerateOtpRequest
import com.example.fitimdiaapp.api.request.VerifyOtpRequest
import com.example.fitimdiaapp.api.response.BaseResponse
import com.example.fitimdiaapp.api.response.VerifyOtpResponse
import com.example.geekssampleapp.constants.APIConstants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST
import java.util.concurrent.TimeUnit

interface RetrofitService {

    @POST(APITags.generateotp)
    fun generateotp(@Body  requestBody: GenerateOtpRequest): Call<BaseResponse>
    @POST(APITags.verifyotp)
    fun verifyotp(@Body  requestBody: VerifyOtpRequest): Call<VerifyOtpResponse>



    companion object {
        var retrofitService: RetrofitService? = null

        fun getInstance() : RetrofitService {
            if (retrofitService == null) {

                val builder: OkHttpClient.Builder = OkHttpClient().newBuilder()
                builder.readTimeout(10, TimeUnit.SECONDS)
                builder.connectTimeout(5, TimeUnit.SECONDS)

                if (BuildConfig.DEBUG) {
                    val interceptor = HttpLoggingInterceptor()
                    interceptor.level = HttpLoggingInterceptor.Level.BODY
                    builder.addInterceptor(interceptor)
                }

                val client: OkHttpClient = builder.build()

                val retrofit = Retrofit.Builder()
                    .baseUrl(APIConstants.BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }
    }
}