package com.example.store;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdapterKeranjang extends RecyclerView.Adapter<AdapterKeranjang.ViewHolder> {
    Context context;
    List<DataKeranjang> itemCarts;
    int totalPrice = 0;
    AdapterKeranjang.PassHarga passHarga;


    public AdapterKeranjang(Context context, List<DataKeranjang> itemCarts, PassHarga passHarga) {
        this.context = context;
        this.itemCarts = itemCarts;
        this.passHarga = passHarga;
    }

    public interface PassHarga{
        void hargaa(int total);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_keranjang,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DataKeranjang db = itemCarts.get(position);

        holder.harga.setText(String.valueOf(db.getHarga()));
        holder.nama.setText(db.getNamaBarang());
        holder.ukuran.setText(db.getNamaBarang());

        Picasso.get().load(Koneksi.gambar+db.getGbrProduk()).error(R.mipmap.ic_launcher).into(holder.imageView);




//        for (int i = 0; i<itemCarts.size(); i++){
//            int todHarga = Integer.parseInt(db.getPrice());
//            totalPrice += todHarga;
//        }
        totalPrice += Integer.parseInt(db.getHarga());
        System.out.println("Total harga = "+String.valueOf(totalPrice));
        passHarga.hargaa(totalPrice);
    }

    @Override
    public int getItemCount() {
        return itemCarts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nama, harga,  ukuran;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nama = itemView.findViewById(R.id.nam);
            harga = itemView.findViewById(R.id.har);
            ukuran = itemView.findViewById(R.id.uk);
            imageView = itemView.findViewById(R.id.gbr2);
        }
    }
}
