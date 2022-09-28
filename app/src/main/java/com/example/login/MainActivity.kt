package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.login.databinding.ActivityMainBinding
import java.lang.Boolean.TRUE

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.StartButtonId.setOnClickListener{
            Log.d("MainActivity","Como que no inicia xD ")

            if (register() == java.lang.Boolean.TRUE){
                val menuOptions = Intent(this,Menu2::class.java)
                startActivity(menuOptions)
            }else{ val registerDevice = Intent(this,RegisterDevice::class.java)
                startActivity(registerDevice)
            }
        }
    }


    private fun register():Boolean{


        return true
    }
}


