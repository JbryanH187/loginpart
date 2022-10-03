package com.example.login.apiconnect;

import com.example.login.modelos.RequestLogin;
import com.example.login.modelos.RequestRegisterDevice;
import com.example.login.modelos.ResponseLogin;
import com.example.login.modelos.ResponseRegisterDevice;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiConnect {

    @POST("checkImei")
    Call<ResponseLogin> getLogin(@Body RequestLogin bodyRequest);

    @POST("imeiRegister")
    Call<ResponseRegisterDevice> getDeviceRegister(@Body RequestRegisterDevice bodyRequest);

}
