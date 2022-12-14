package com.example.store;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {

    TextView tvDaftarSekarang;
    Button login1;
    EditText username;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        tvDaftarSekarang = findViewById(R.id.id_daftar_sekarang);
        login1 = findViewById(R.id.login_app);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Services service = Koneksi.getService().create(Services.class);
                Call<ResponsePost> simpan = service.setLogin(username.getText().toString(), password.getText().toString());
                simpan.enqueue(new Callback<ResponsePost>() {
                    @Override
                    public void onResponse(Call<ResponsePost> call, Response<ResponsePost> response) {
                        byte kode = response.body().getKode();
                        if (kode == 1) {
//                            shared = getSharedPreferences("myapp-data", MODE_PRIVATE);
//                            SharedPreferences.Editor editor = shared.edit();
//                            editor.putBoolean("status", true);
//                            editor.commit();
                            Toast.makeText(Login.this, "Berhasil Login", Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                            intent.putExtra("user",username.getText().toString());
                            startActivity(intent);
                        } else if (kode == 0) {
                            Toast.makeText(Login.this, "Gagal Login", Toast.LENGTH_SHORT).show();
                        }
                    }



                    @Override
                    public void onFailure(Call<ResponsePost> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Error server : " + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        tvDaftarSekarang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),register.class);
                startActivity(intent);
            }
        });
    }
}