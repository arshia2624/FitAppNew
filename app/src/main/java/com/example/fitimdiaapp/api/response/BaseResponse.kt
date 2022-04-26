package com.example.fitimdiaapp.api.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class BaseResponse {

    @SerializedName("success")
    @Expose
    var success:Boolean?=null

    @SerializedName("hash")
    @Expose
    var hash:String?=null


    @SerializedName("otp")
    @Expose
    var otp:Long?=null

}