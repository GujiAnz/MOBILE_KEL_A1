package com.example.store;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import androidx.appcompat.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class search extends AppCompatActivity {
    private RecyclerView rvData;
    private RecyclerView.Adapter adData;
    private RecyclerView.LayoutManager lmData;
    private List<DataBarang> listData = new ArrayList<>();
    RecyclerView recyclerView;
    SearchView searchView;
    AdapterCari adapterCari;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        retrieveData();

        rvData = findViewById(R.id.Tvrecycleview12);
        lmData = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rvData.setLayoutManager(lmData);

        searchView = findViewById(R.id.searchoke);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                FilterList(newText);
                return true;
            }
        });
    }

    public void FilterList(String text){

        List<DataBarang> FilteredList = new ArrayList<>();
        for (DataBarang brg : listData){
            if (brg.getNama_barang().toLowerCase().contains(text.toLowerCase())){

                FilteredList.add(brg);
            }
        }

        if (FilteredList.isEmpty()){
            Toast.makeText(search.this, "No Data", Toast.LENGTH_SHORT).show();
        } else {

            adapterCari.setFilteredList(FilteredList);
        }
    }
    public void retrieveData() {
        Services ai = Koneksi.getService().create(Services.class);
        Call<ResponseBaju> tampilData = ai.ardretriveData();
        tampilData.enqueue(new Callback<ResponseBaju>() {
            @Override
            public void onResponse(Call<ResponseBaju> call, Response<ResponseBaju> response) {
                int kode = response.body().getKode();
                String pesan = response.body().getPesan();


                Toast.makeText(search.this, "Kode : "+kode+" | Pesan : "+pesan, Toast.LENGTH_SHORT).show();

                listData = response.body().getData();

                adapterCari = new AdapterCari(search.this, listData);
                rvData.setAdapter(adapterCari);
                adapterCari.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<ResponseBaju> call, Throwable t) {
                Toast.makeText(search.this, "Gagal Menghubungi Server : "+t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}