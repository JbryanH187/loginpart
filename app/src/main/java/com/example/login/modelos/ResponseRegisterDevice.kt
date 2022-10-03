package com.example.login.modelos

import com.google.gson.annotations.SerializedName

class ResponseRegisterDevice(resultRegisterDevice: Boolean, messageRegisterDevice: String) {

    @SerializedName("resultado")
    var resultRegisterDevice: Boolean = resultRegisterDevice

    @SerializedName("mensaje")
    var messageRegisterDevice: String? = messageRegisterDevice

}