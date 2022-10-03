package com.example.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.login.databinding.ActivityMainBinding
import com.example.login.databinding.ActivityMenu2Binding
import com.example.login.utilities.Utilities

class Menu2 : AppCompatActivity() {


    private val u: Utilities = Utilities()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu2)

    }
}