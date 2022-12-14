package com.example.store;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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


public class KeranjangFragment extends Fragment {
    RecyclerView recyclerView;
    AdapterKeranjang adapterCartUser;
    List<DataKeranjang> ngengek = new ArrayList<>();
    Services ipe_interface;
    TextView totalHarga;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
       showChart();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_keranjang, container, false);
    }
    public void showChart(){
        totalHarga = (TextView) getView().findViewById(R.id.harga);

        AdapterKeranjang.PassHarga passHarga = new AdapterKeranjang.PassHarga() {
            @Override
            public void hargaa(int total) {
                System.out.println("Tesss Jumlahnyaaaa "+String.valueOf(total));
                totalHarga.setText(String.valueOf(total));
            }
        };
        ipe_interface = Koneksi.getService().create(Services.class);
        Call<ResponseKeranjang> call = ipe_interface.get_Cart(getActivity().getIntent().getStringExtra("user"));
        call.enqueue(new Callback<ResponseKeranjang>() {
            @Override
            public void onResponse(Call<ResponseKeranjang> call, Response<ResponseKeranjang> response) {
                int kode = response.body().getKode();
                if(kode==1){

                    ngengek = response.body().getData();
                    adapterCartUser = new AdapterKeranjang(getActivity(),ngengek,passHarga);
                    recyclerView = getView().findViewById(R.id.rcKeranjang);
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                    recyclerView.setAdapter(adapterCartUser);
                    adapterCartUser.notifyDataSetChanged();
                }else {
                    Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<ResponseKeranjang> call, Throwable t) {

            }
        });
    }
}