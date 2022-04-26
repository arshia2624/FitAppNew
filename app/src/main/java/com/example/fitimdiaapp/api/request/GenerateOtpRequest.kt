package com.example.fitimdiaapp.api.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

public class GenerateOtpRequest {
    @SerializedName("phone_no")
    @Expose
    var phone_no: String? = null
}