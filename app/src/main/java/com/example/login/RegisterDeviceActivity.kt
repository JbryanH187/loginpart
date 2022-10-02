package com.example.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.login.databinding.ActivityRegisterDeviceBinding
import com.example.login.modelos.RequestRegisterDevice
import com.example.login.modelos.ResponseLogin
import com.example.login.modelos.ResponseRegisterDevice
import com.example.login.utilities.Utilities
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterDeviceActivity : AppCompatActivity(){

    private var u: Utilities = Utilities()
    private lateinit var binding: ActivityRegisterDeviceBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_device)

        binding = ActivityRegisterDeviceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.deviceNameRegisterId.text

        binding.registerButtonId.setOnClickListener{


        }

    }


}