package com.example.store;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class Koneksi {
    public static String base_url = "http://172.16.101.148/Database/";
    public static  String gambar = "http://172.16.101.148/Database/gambar/";
    private static Retrofit retro;
;
    public static Retrofit getService(){

        if(retro == null){
            retro = new Retrofit.Builder().baseUrl(base_url)
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retro;
    }
}
