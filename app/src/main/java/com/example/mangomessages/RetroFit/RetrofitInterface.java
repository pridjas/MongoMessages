package com.example.mangomessages.RetroFit;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RetrofitInterface {


    @POST("/storeString")
    Call<Void> storeString(@Body HashMap<String, String> map);


}
