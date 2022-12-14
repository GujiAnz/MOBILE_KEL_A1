package com.example.store;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import Adapter.AdapterBaju;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment {

        private RecyclerView rvData;
        private RecyclerView.Adapter adData;
        private RecyclerView.LayoutManager lmData;
        private List<DataBarang> listData = new ArrayList<>();
        Button allinSemesta,Celana,jaket,kaos;
        ImageButton imgbtn;
        CardView cardView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    BottomNavigationView bottomNavigationView;
    //    ImageView Img;
    List<ModelBaju> listModelBaju = new ArrayList<>();

    void intializeDataBaju(){
        listModelBaju.add(new ModelBaju("White Sweater",100000,R.drawable.img_1));
        listModelBaju.add(new ModelBaju("Black Sweater",130000,R.drawable.img_4));
        listModelBaju.add(new ModelBaju("Red Sweater",150000,R.drawable.img_3));
        listModelBaju.add(new ModelBaju("Purple Sweater",130000,R.drawable.img_7));
        listModelBaju.add(new ModelBaju("Gray Sweater",341000,R.drawable.img_5));
    }
    RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        intializeDataBaju();


        return inflater.inflate(R.layout.fragment_home, container, false);
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        retrieveData();
        Tes();
        Tes2();
        Tes3();
        Tes4();
        Tosearch();
        cardView = view.findViewById(R.id.cardView2);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),search.class);
                startActivity(intent);
            }
        });
//        AdapterBaju.ItemClickListener adapterItemClick = new AdapterBaju.ItemClickListener() {
//            @Override
//            public void clikcbajuListener(int posisi) {
//                ModelBaju mdlBjau = listModelBaju.get(posisi);
//                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new DeskripsiFragment(listModelBaju.get((posisi)))).commit();
//            }
//        };
//        AdapterBaju adapterBaju = new AdapterBaju(listModelBaju,adapterItemClick);
////        recyclerView.setAdapter(adapterBaju);

    }

    public void Tes(){
        allinSemesta = getView().findViewById(R.id.all);
        allinSemesta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retrieveData();
            }
        });
    }

    public void Tes2(){
        Celana = getView().findViewById(R.id.celanaa);
        Celana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retriveCelana();
            }
        });
    }

    public void Tes3(){
        jaket = getView().findViewById(R.id.jaket);
        jaket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retriveJaket();
            }
        });
    }

    public void Tes4(){
        kaos = getView().findViewById(R.id.Kaos);
        kaos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retriveKaos();
            }
        });
    }

    public void retrieveData() {
        Services ai = Koneksi.getService().create(Services.class);
        Call<ResponseBaju> tampilData = ai.ardretriveData();
        tampilData.enqueue(new Callback<ResponseBaju>() {
            @Override
            public void onResponse(Call<ResponseBaju> call, Response<ResponseBaju> response) {
                int kode = response.body().getKode();
                String pesan = response.body().getPesan();


                Toast.makeText(getActivity(), "Kode : "+kode+" | Pesan : "+pesan, Toast.LENGTH_SHORT).show();

                listData = response.body().getData();

                adData = new AdapterBarang(getContext(), listData);

                recyclerView = getView().findViewById(R.id.id_baju_home);
                rvData = getView().findViewById(R.id.id_baju_home);
                rvData.setHasFixedSize(true);
                rvData.setLayoutManager(new GridLayoutManager(getActivity(),2));
                rvData.setAdapter(adData);
                adData.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<ResponseBaju> call, Throwable t) {
                Toast.makeText(getActivity(), "Gagal Menghubungi Server : "+t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void Tosearch(){
        imgbtn = getView().findViewById(R.id.imgbtn);
        imgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), cart1.class);
                i.putExtra("user", getActivity().getIntent().getStringExtra("user"));
                startActivity(i);
            }
        });
    }

    public void retriveCelana(){
        Services services = Koneksi.getService().create(Services.class);
        Call<ResponseBaju> call = services.ardretriveDataCelana();
        call.enqueue(new Callback<ResponseBaju>() {
            @Override
            public void onResponse(Call<ResponseBaju> call, Response<ResponseBaju> response) {
                listData = response.body().getData();

                adData = new AdapterBarang(getContext(), listData);

                recyclerView = getView().findViewById(R.id.id_baju_home);
                rvData = getView().findViewById(R.id.id_baju_home);
                rvData.setHasFixedSize(true);
                rvData.setLayoutManager(new GridLayoutManager(getActivity(),2));
                rvData.setAdapter(adData);
                adData.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ResponseBaju> call, Throwable t) {

            }
        });
    }

    public void retriveJaket(){
        Services services = Koneksi.getService().create(Services.class);
        Call<ResponseBaju> call = services.ardretriveDataJaket();
        call.enqueue(new Callback<ResponseBaju>() {
            @Override
            public void onResponse(Call<ResponseBaju> call, Response<ResponseBaju> response) {
                listData = response.body().getData();

                adData = new AdapterBarang(getContext(), listData);

                recyclerView = getView().findViewById(R.id.id_baju_home);
                rvData = getView().findViewById(R.id.id_baju_home);
                rvData.setHasFixedSize(true);
                rvData.setLayoutManager(new GridLayoutManager(getActivity(),2));
                rvData.setAdapter(adData);
                adData.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ResponseBaju> call, Throwable t) {

            }
        });
    }

    public void retriveKaos(){
        Services services = Koneksi.getService().create(Services.class);
        Call<ResponseBaju> call = services.ardretriveDataKaos();
        call.enqueue(new Callback<ResponseBaju>() {
            @Override
            public void onResponse(Call<ResponseBaju> call, Response<ResponseBaju> response) {
                listData = response.body().getData();

                adData = new AdapterBarang(getContext(), listData);

                recyclerView = getView().findViewById(R.id.id_baju_home);
                rvData = getView().findViewById(R.id.id_baju_home);
                rvData.setHasFixedSize(true);
                rvData.setLayoutManager(new GridLayoutManager(getActivity(),2));
                rvData.setAdapter(adData);
                adData.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ResponseBaju> call, Throwable t) {

            }
        });
    }
}