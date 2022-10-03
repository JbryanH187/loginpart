package com.example.login.modelos

import com.google.gson.annotations.SerializedName

<<<<<<< HEAD
class RequestRegisterDevice(deviceName: String, deviceImei:String) {

    @SerializedName("dispositivo")
    var deviceName: String? = deviceName

    @SerializedName("imei")
    var deviceImei: String? = deviceImei
=======
class RequestRegisterDevice(deviceRegister:String, imeiDevice: String) {

    @SerializedName("dispositivo")
    var deviceRegister: String? = deviceRegister

    @SerializedName("imei")
    var imeiDevice: String? = imeiDevice
>>>>>>> 2766b76aa7644483e7455fdd76a35c238cfba6e9

}