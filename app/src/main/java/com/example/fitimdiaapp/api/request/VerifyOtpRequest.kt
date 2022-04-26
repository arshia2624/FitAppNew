package com.example.fitimdiaapp.api.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class VerifyOtpRequest {
    @SerializedName("phone_no")
    @Expose
    var phone_no: String? = null
    @SerializedName("hash")
    @Expose
    var hash: String? = null
    @SerializedName("otp")
    @Expose
    var otp: String? = null
    @SerializedName("expires")

    @Expose
    var expires: String? = null
}