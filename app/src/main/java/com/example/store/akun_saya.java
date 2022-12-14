package com.example.store;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class akun_saya extends AppCompatActivity {
    TextView nama , telp , email;
    Services services;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_akun_saya);
        setProfile();
    }

    public void setProfile(){
        nama = (TextView) findViewById(R.id.namaUser);
        telp = (TextView) findViewById(R.id.telpUser);
        email = (TextView) findViewById(R.id.emailUser);

        services = Koneksi.getService().create(Services.class);
        Call<Tesss> userCall = services.getDataUser(getIntent().getStringExtra("user"));
        userCall.enqueue(new Callback<Tesss>() {
            @Override
            public void onResponse(Call<Tesss> call, Response<Tesss> response) {
                nama.setText(response.body().getData().getNamaPembeli());
                telp.setText(response.body().getData().getNoTelp());
                email.setText(response.body().getData().getEmailPembeli());
            }

            @Override
            public void onFailure(Call<Tesss> call, Throwable t) {

            }
        });




    }
}