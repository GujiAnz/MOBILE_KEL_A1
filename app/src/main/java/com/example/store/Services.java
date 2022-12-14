package com.example.store;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Services {
    @FormUrlEncoded
    @POST("login.php")
    Call<ResponsePost> setLogin(
            @Field("email_pembeli") String email_pembeli,
            @Field("password_pembeli") String password_pembeli
    );

    @FormUrlEncoded
    @POST("DataUser.php")
    Call<Tesss> getDataUser(
            @Field("username") String user
    );
    @FormUrlEncoded
    @POST("register.php")
    Call<Responregister> setregister(
            @Field("email_pembeli") String email_pembeli,
            @Field("password_pembeli") String password_pembeli,
            @Field("nama_pembeli") String nama_pembeli,
            @Field("jenis_kelamin") String jenis_kelamin,
            @Field("no_telp") String no_telp
    );
    @GET("retrive.php")
    Call<ResponseBaju> ardretriveData();

    @GET("celana.php")
    Call<ResponseBaju> ardretriveDataCelana();

    @GET("jaket.php")
    Call<ResponseBaju> ardretriveDataJaket();

    @GET("kaos.php")
    Call<ResponseBaju> ardretriveDataKaos();

    @FormUrlEncoded
    @POST("cart.php")
    Call<ResponseCart> ardretriveCart(
            @Field("id_barang") String id_barang,
            @Field("nama_barang") String nama_barang,
            @Field("harga") String harga,
            @Field("ukuran") String ukuran,
            @Field("id_pembeli") String id_pembeli
    );

    @FormUrlEncoded
    @POST("keranjang.php")
    Call<ResponseKeranjang> get_Cart(
            @Field("id_pembeli") String id_pembeli
    );


}
