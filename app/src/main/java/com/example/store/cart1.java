package com.example.store;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class cart1 extends AppCompatActivity {
    RecyclerView recyclerView;
    AdapterKeranjang adapterCartUser;
    List<DataKeranjang> tampil = new ArrayList<>();
    Services ipe_interface;
    TextView totalHarga;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart1);
        showChart();
    }

    public void showChart(){
        totalHarga = (TextView) findViewById(R.id.harga);

        AdapterKeranjang.PassHarga passHarga = new AdapterKeranjang.PassHarga() {
            @Override
            public void hargaa(int total) {
                System.out.println("Tesss Jumlahnyaaaa "+String.valueOf(total));
                totalHarga.setText(String.valueOf(total));
            }
        };
        ipe_interface = Koneksi.getService().create(Services.class);
        Call<ResponseKeranjang> call = ipe_interface.get_Cart(getIntent().getStringExtra("user"));
        call.enqueue(new Callback<ResponseKeranjang>() {
            @Override
            public void onResponse(Call<ResponseKeranjang> call, Response<ResponseKeranjang> response) {
                int kode = response.body().getKode();
                if(kode==1){

                    tampil = response.body().getData();
                    adapterCartUser = new AdapterKeranjang(cart1.this,tampil,passHarga);
                    recyclerView = findViewById(R.id.rcKeranjang);
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setLayoutManager(new LinearLayoutManager(cart1.this));
                    recyclerView.setAdapter(adapterCartUser);
                    adapterCartUser.notifyDataSetChanged();
                }else {
                    Toast.makeText(cart1.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseKeranjang> call, Throwable t) {

            }
        });
    }
}