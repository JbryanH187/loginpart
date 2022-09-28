package com.example.login

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.TelephonyManager
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import com.example.login.databinding.ActivityMainBinding
import java.lang.Boolean.FALSE
import java.lang.Boolean.TRUE

class MainActivity : AppCompatActivity() {

    private val REQUEST_CODE = 101
    private lateinit var binding: ActivityMainBinding

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        try{
            val telephonyManager = getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
            val IMEI = telephonyManager.getImei()
            if (IMEI != null)
                Toast.makeText(this, "IMEI number: " + IMEI,
                    Toast.LENGTH_LONG).show()
        }catch (ex:Exception){
            ex.message?.let { Log.e("", it) }
        }

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            // if permissions are not provided we are requesting for permissions.
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_PHONE_STATE), REQUEST_CODE)
        }

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.StartButtonId.setOnClickListener{

            Log.d("MainActivity","Como que no inicia xD ")

            if (register() == java.lang.Boolean.TRUE){
                val menuOptions = Intent(this,Menu2::class.java)
                startActivity(menuOptions)
            }else{ val registerDevice = Intent(this,RegisterDeviceActivity::class.java)
                startActivity(registerDevice)
            }
        }
    }
    private fun register():Boolean{

    return FALSE
    }
}



