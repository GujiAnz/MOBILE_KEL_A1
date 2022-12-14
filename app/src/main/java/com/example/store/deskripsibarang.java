package com.example.store;

import static com.example.store.Koneksi.gambar;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class deskripsibarang extends AppCompatActivity {
 String image,tvUkuran,nama_barang,harga,deskripsi,tvWarna, id;
 ImageView gbr, keranjang;
 TextView nama,tvHarga,deks,ukuran,warna;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deskripsibarang);
        gbr = findViewById(R.id.deskaos);
        tvHarga = findViewById(R.id.hargaBajuu);
        nama = findViewById(R.id.nmBrg);
        ukuran = findViewById(R.id.txtuk);
        deks = findViewById(R.id.txtbahan);
        warna = findViewById(R.id.txtasal);
//        //tambahan
//
        id = getIntent().getStringExtra("id_barang");
        nama_barang = getIntent().getStringExtra("nama_barang");
        harga = getIntent().getStringExtra("harga");
        deskripsi = getIntent().getStringExtra("deskripsi");
        tvUkuran = getIntent().getStringExtra("ukuran");
        image = getIntent().getStringExtra("image");
        tvWarna = getIntent().getStringExtra("warna");
        nama.setText(nama_barang);
//        // Hehe
        deks.setText("Deskripsi : "+deskripsi);
        warna.setText("Warna : "+tvWarna);
        tvHarga.setText(String.valueOf(harga));
        ukuran.setText("Ukuran : "+tvUkuran);
//
        Picasso.get().load(Koneksi.gambar+image).error(R.mipmap.ic_launcher).into(gbr);

        keranjang = findViewById(R.id.tokeranjang);
        keranjang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id_user = getIntent().getStringExtra("user");
                System.out.println("Mau Insert id = "+id_user);
                Services ipe_interface = Koneksi.getService().create(Services.class);
                Call<ResponseCart> call = ipe_interface.ardretriveCart(id,nama_barang,harga,tvUkuran,id_user);
                call.enqueue(new Callback<ResponseCart>() {
                    @Override
                    public void onResponse(Call<ResponseCart> call, Response<ResponseCart> response) {
                        Toast.makeText(deskripsibarang.this, String.valueOf(response.body().getKode()), Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(getApplicationContext(),cart1.class);
                        i.putExtra("user",id_user);
                        startActivity(i);
                    }

                    @Override
                    public void onFailure(Call<ResponseCart> call, Throwable t) {
                        System.out.println(t.getMessage());

                    }
                });
            }
        });
    }
}