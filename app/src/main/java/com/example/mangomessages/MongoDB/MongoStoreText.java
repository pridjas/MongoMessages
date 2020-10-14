package com.example.mangomessages.MongoDB;

import android.widget.Toast;

import com.example.mangomessages.MainActivity.MainActivity;
import com.example.mangomessages.RetroFit.RetrofitInterface;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MongoStoreText {
    private Retrofit retrofit;
    private RetrofitInterface retrofitInterface;
    private String BASE_URL = "http://10.0.2.2:3002";
    boolean isInserted = true;

    public boolean storeTextToDB(String inputTextEditText) {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retrofitInterface = retrofit.create(RetrofitInterface.class);

        HashMap<String, String> map = new HashMap<>();
        map.put("userInput", inputTextEditText);

        Call<Void> call = retrofitInterface.storeString(map);

        call.enqueue(new Callback<Void>() {

            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

                if (response.code() == 200) {
                    isInserted = true;

                } else if (response.code() == 400) {
                    isInserted = false;

                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                isInserted = false;
            }
        });

        return isInserted;
    }

}
