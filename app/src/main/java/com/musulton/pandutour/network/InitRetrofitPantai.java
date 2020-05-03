package com.musulton.pandutour.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Muhammad Sulton on 18/08/18.
 * @musulton
 */

public class InitRetrofitPantai {
    // URL Server API
    public static String API_URL = "http://192.168.43.157/sig/mobile/";

    public static Retrofit setInit() {
        return new Retrofit.Builder().baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ApiServicesPantai getInstance() {
        return setInit().create(ApiServicesPantai.class);
    }

}