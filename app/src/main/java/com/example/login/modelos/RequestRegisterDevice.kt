package com.example.login.modelos

import com.google.gson.annotations.SerializedName

class RequestRegisterDevice(deviceName: String, deviceImei:String) {

    @SerializedName("dispositivo")
    var deviceName: String? = deviceName

    @SerializedName("imei")
    var deviceImei: String? = deviceImei

}