package com.example.store;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        intializeDataBaju();
        recyclerView = findViewById(R.id.id_rec_baju_home);
        AdapterBaju adapterBaju = new AdapterBaju(listModelBaju);
        recyclerView.setAdapter(adapterBaju);

    }
}