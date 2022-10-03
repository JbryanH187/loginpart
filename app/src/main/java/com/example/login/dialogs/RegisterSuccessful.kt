package com.example.login.dialogs

import android.app.Activity
import android.app.AlertDialog
import com.example.login.R

class Load(private var uActivity: Activity) {

    private lateinit var isDialog: AlertDialog
    fun startLoading(){

        val infalter = uActivity.layoutInflater

        val dialogView = infalter.inflate(R.layout.registersuccessful,null)
        val builder = AlertDialog.Builder(uActivity)
        builder.setView(dialogView)
        builder.setCancelable(false)
        isDialog = builder.create()
        isDialog.show()

    }
    fun isDismiss(){
        isDialog.dismiss()
    }

}