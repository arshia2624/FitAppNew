package com.example.fitimdiaapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.fitimdiaapp.R
import com.example.fitimdiaapp.databinding.ActivityPhoneNumberScreenBinding
import com.example.fitimdiaapp.helper.GenericTextWatcher
import com.example.fitimdiaapp.utils.SharedPrefUtils
import com.example.fitimdiaapp.utils.StringUtils

class PhoneNumberScreen : AppCompatActivity() {
    lateinit var phoneNumberScreenBinding: ActivityPhoneNumberScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        phoneNumberScreenBinding =DataBindingUtil.setContentView(this,R.layout.activity_phone_number_screen)
    }



    fun onClick(view: android.view.View) {
        if(phoneNumberScreenBinding.etMobNo.text.toString().equals("")|| phoneNumberScreenBinding.etMobNo.text.toString().equals(null) || phoneNumberScreenBinding.etMobNo.text.length<10){
            Toast.makeText(
                this,
                "Please enter Mobile Number",
                Toast.LENGTH_SHORT
            ).show()
            return
        }
        else{

/*
            SharedPrefUtils.getInstanceShared(this).setStringObject(phoneNumberScreenBinding.etMobNo.text.toString(),SharedPrefUtils.phoneNumber)
*/

            val intent: Intent = Intent(this, OtpScreen::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NO_ANIMATION
            intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
        }

    }
}