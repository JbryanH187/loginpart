package com.example.login.modelos

import com.google.gson.annotations.SerializedName

class ResponseLogin(resultLogin: Boolean,messageLogin: String){

    @SerializedName("resultado")
    var resultLogin: Boolean? = resultLogin

    @SerializedName("mensaje")
    var messageLogin: String? = messageLogin

}