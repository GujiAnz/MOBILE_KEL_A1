package com.example.store;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class Koneksi {
    public static String base_url = "http://192.168.1.13/Database/";
    private static Retrofit retro;

    public static Retrofit getService(){

        if(retro == null){
            retro = new Retrofit.Builder().baseUrl(base_url)
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retro;
    }
}
