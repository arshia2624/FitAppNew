package com.example.fitimdiaapp.api

import com.example.fitimdiaapp.api.response.BaseResponse
import retrofit2.Response
import retrofit2.http.POST


public interface APIservice {

    @POST(APITags.generateotp)
    suspend fun generateotp(): Response<BaseResponse>

}