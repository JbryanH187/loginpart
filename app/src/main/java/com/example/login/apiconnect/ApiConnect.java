package com.example.login.apiconnect;

import com.example.login.modelos.RequestLogin;
import com.example.login.modelos.ResponseLogin;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiConnect {

    @POST("checkImei")
    Call<ResponseLogin> getLogin(@Body RequestLogin bodyRequest);

}
