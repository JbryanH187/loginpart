package com.example.login.modelos

import com.google.gson.annotations.SerializedName

class ResponseRegisterDevice(resultDeviceRegister:Boolean, messageDeviceRegister:String) {

    @SerializedName("resultado")
    var resultDeviceRegister: Boolean = resultDeviceRegister

    @SerializedName("mensaje")
    var messageDeviceRegister: String? = messageDeviceRegister


}