package com.example.login.modelos

import com.google.gson.annotations.SerializedName

class RequestLogin(deviceImei: String) {

    @SerializedName("imei")
    var deviceImei: String? = deviceImei

}