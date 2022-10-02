package com.example.login.modelos

import com.google.gson.annotations.SerializedName

class RequestRegisterDevice(deviceRegister:String, imeiDevice: String) {

    @SerializedName("dispositivo")
    var deviceRegister: String? = deviceRegister

    @SerializedName("imei")
    var imeiDevice: String? = imeiDevice

}