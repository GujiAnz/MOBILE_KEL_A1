package com.example.store;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class register extends AppCompatActivity {

    TextView TvLoginsekarang;
    Button btn_daftar;
    EditText texin1,texin2,texin3,texin4,texin5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        TvLoginsekarang=findViewById(R.id.id_loginsekarang);
        btn_daftar=findViewById(R.id.btn_daftar);
        texin1 = findViewById(R.id.id_edit_nama);
        texin2 = findViewById(R.id.id_edit_jns);
        texin3 = findViewById(R.id.id_edit_username);
        texin4 = findViewById(R.id.id_email);
        texin5 = findViewById(R.id.id_edit_password);

        TvLoginsekarang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
            }
        });
        btn_daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Services service = Koneksi.getService().create(Services.class);
                Call<Responregister> simpan = service.setregister(texin4.getText().toString(),texin5.getText().toString(),texin1.getText().toString(),texin2.getText().toString(),texin3.getText().toString());
                simpan.enqueue(new Callback<Responregister>() {
                    @Override
                    public void onResponse(Call<Responregister> call, Response<Responregister> response) {
                     int kode = response.body().getKode();

                        if (kode == 1) {
//                            shared = getSharedPreferences("myapp-data", MODE_PRIVATE);
//                            SharedPreferences.Editor editor = shared.edit();
//                            editor.putBoolean("status", true);
//                            editor.commit();
                            Toast.makeText(register.this, "Berhasil Daftar", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(),Login.class);
                            startActivity(intent);
                        } else if (kode == 0) {
                            Toast.makeText(register.this, "Gagal Daftar", Toast.LENGTH_SHORT).show();
                        }
                    }



                    @Override
                    public void onFailure(Call<Responregister> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Error server : " + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


    }
}