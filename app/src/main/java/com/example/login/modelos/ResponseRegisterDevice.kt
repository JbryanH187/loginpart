package com.example.login.modelos

import com.google.gson.annotations.SerializedName

<<<<<<< HEAD
class ResponseRegisterDevice(resultRegisterDevice: Boolean, messageRegisterDevice: String) {

    @SerializedName("resultado")
    var resultRegisterDevice: Boolean = resultRegisterDevice

    @SerializedName("mensaje")
    var messageRegisterDevice: String? = messageRegisterDevice
=======
class ResponseRegisterDevice(resultDeviceRegister:Boolean, messageDeviceRegister:String) {

    @SerializedName("resultado")
    var resultDeviceRegister: Boolean = resultDeviceRegister

    @SerializedName("mensaje")
    var messageDeviceRegister: String? = messageDeviceRegister

>>>>>>> 2766b76aa7644483e7455fdd76a35c238cfba6e9

}