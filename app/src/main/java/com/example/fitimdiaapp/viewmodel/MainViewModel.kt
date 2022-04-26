package com.example.fitimdiaapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fitimdiaapp.api.request.GenerateOtpRequest
import com.example.fitimdiaapp.api.response.BaseResponse
import com.example.fitimdiaapp.api.response.VerifyOtpResponse
import com.example.fitimdiaapp.repository.MainRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainViewModel constructor(private val repository: MainRepository)  : ViewModel() {
    val otpResponse = MutableLiveData<BaseResponse>()
    val verifyotpResponse = MutableLiveData<VerifyOtpResponse>()

    val errorMessage = MutableLiveData<String>()
    val input = MutableLiveData<String>()

    fun callOtpAPI() {
        val response = repository.generateotp()
        response?.enqueue(object : Callback<BaseResponse> {
            override fun onResponse(call: Call<BaseResponse>, response: Response<BaseResponse>) {
                otpResponse.postValue(response.body())
            }

            override fun onFailure(call: Call<BaseResponse>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }
        fun callVerifyOtpAPI() {
            val response = repository.verifyotp()
            response?.enqueue(object : Callback<VerifyOtpResponse> {
                override fun onResponse(
                    call: Call<VerifyOtpResponse>,
                    response: Response<VerifyOtpResponse>
                ) {
                    verifyotpResponse.postValue(response.body())
                }

                override fun onFailure(call: Call<VerifyOtpResponse>, t: Throwable) {
                    errorMessage.postValue(t.message)
                }
            })
        }

    }
