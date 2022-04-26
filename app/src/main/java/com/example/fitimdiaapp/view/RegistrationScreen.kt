package com.example.fitimdiaapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.fitimdiaapp.R
import com.example.fitimdiaapp.databinding.ActivityOtpScreenBinding
import com.example.fitimdiaapp.databinding.ActivityRegistrationScreenBinding

class RegistrationScreen : AppCompatActivity() {
    lateinit var registrationScreenBinding: ActivityRegistrationScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      registrationScreenBinding =DataBindingUtil.setContentView(this,R.layout.activity_registration_screen)
        val view: View = registrationScreenBinding.getRoot()

        var textView = view.findViewById<TextView>(R.id.header_common)
        textView.text = "Registration"
    }
}