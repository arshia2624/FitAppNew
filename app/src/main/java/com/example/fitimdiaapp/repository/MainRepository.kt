package com.example.fitimdiaapp.repository

import com.example.fitimdiaapp.api.APIservice
import com.example.fitimdiaapp.api.request.GenerateOtpRequest
import com.example.fitimdiaapp.api.request.VerifyOtpRequest
import com.example.geekssampleapp.api.RetrofitService

class MainRepository constructor(
    private val retrofitService: RetrofitService,
    private val request: GenerateOtpRequest
) {
    var request1: VerifyOtpRequest

    fun generateotp() = retrofitService.generateotp(request)

    init {
        request1 = VerifyOtpRequest()
    }

    fun verifyotp() = retrofitService.verifyotp(request1)

}