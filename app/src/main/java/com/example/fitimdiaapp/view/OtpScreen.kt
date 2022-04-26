package com.example.fitimdiaapp.view

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.fitimdiaapp.R
import com.example.fitimdiaapp.api.request.GenerateOtpRequest
import com.example.fitimdiaapp.databinding.ActivityOtpScreenBinding
import com.example.fitimdiaapp.databinding.ActivityPhoneNumberScreenBinding
import com.example.fitimdiaapp.repository.MainRepository
import com.example.fitimdiaapp.repository.MyViewModelFactory
import com.example.fitimdiaapp.utils.SharedPrefUtils
import com.example.fitimdiaapp.viewmodel.MainViewModel
import com.example.geekssampleapp.api.RetrofitService

class OtpScreen : AppCompatActivity() {
    lateinit var otpactivityBinding: ActivityOtpScreenBinding
    lateinit var viewModel: MainViewModel
    private val retrofitService = RetrofitService.getInstance()
    lateinit var requestOTP:GenerateOtpRequest
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        otpactivityBinding =DataBindingUtil.setContentView(this,R.layout.activity_otp_screen)
        val view: View = otpactivityBinding.getRoot()
        var textView = view.findViewById<TextView>(R.id.header_common)
        textView.text = "Mobile Verification"
        requestOTP= GenerateOtpRequest()
/*
        requestOTP.phone_no=SharedPrefUtils.getInstanceShared(SharedPrefUtils(),this)?.getStringObject(SharedPrefUtils.phoneNumber)
*/
        viewModel = ViewModelProvider(this, MyViewModelFactory(MainRepository(retrofitService,requestOTP))).get(MainViewModel::class.java)
        otpactivityBinding.loading = true
        viewModel.otpResponse.observe(this, Observer {
            Log.d(ContentValues.TAG, "onCreate: $it")

            otpactivityBinding.loading = false
            Toast.makeText(
                this,
                "${it.otp}",
                Toast.LENGTH_SHORT
            ).show()


        })
        viewModel.errorMessage.observe(this, Observer {
            Log.d(ContentValues.TAG, "onCreate: $it")
            otpactivityBinding.loading = false

        })
        viewModel.callOtpAPI()
    }

    fun onClick(view: android.view.View) {
        val  otp = otpactivityBinding.etOtp.text?.length
        if(otpactivityBinding.etOtp.text.toString() == "" || otpactivityBinding.etOtp.text.toString().equals(null) ){
            Toast.makeText(
                this,
                "Please enter OTP",
                Toast.LENGTH_SHORT
            ).show()
            return
        }

        else if (otp!! <4){
            Toast.makeText(
                this,
                "Please enter correct OTP",
                Toast.LENGTH_SHORT
            ).show()
            return
        }
        else{
            otpactivityBinding.tvSubmit.isEnabled =true
            viewModel.callVerifyOtpAPI()
            viewModel.verifyotpResponse.observe(this, Observer {

                val intent: Intent = Intent(this, RegistrationScreen::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NO_ANIMATION
                intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
                startActivity(intent)


            })

        }
    }
}