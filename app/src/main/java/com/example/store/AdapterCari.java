package com.example.store;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterCari extends RecyclerView.Adapter<AdapterCari.HolderData> {

    Context ctx;
    List<DataBarang> listData;

    public AdapterCari(Context ctx, List<DataBarang> listData) {
        this.ctx = ctx;
        this.listData = listData;
    }

    public void setFilteredList(List<DataBarang> filteredList) {
        this.listData = filteredList;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public AdapterCari.HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(ctx).inflate(R.layout.serchcard, parent, false);
//        HolderData holder = new HolderData(layout);
        return new HolderData(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterCari.HolderData holder, @SuppressLint("RecyclerView") int position) {
        DataBarang db = listData.get(position);

        holder.nama.setText(String.valueOf(db.getNama_barang()));
        holder.jenis.setText(String.valueOf(db.getHarga_jual()));
        Picasso.get().load(Koneksi.gambar+listData.get(position).getGbr_produk()).into(holder.gambar);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent =  new Intent(view.getContext(), deskripsibarang.class);
                mIntent.putExtra("image", listData.get(position).getGbr_produk());
                mIntent.putExtra("barang_jenis", listData.get(position).getKategori());
                mIntent.putExtra("nama_barang", listData.get(position).getNama_barang());
                mIntent.putExtra("harga", String.valueOf(listData.get(position).getHarga_jual()));
                mIntent.putExtra("deskripsi", listData.get(position).getDeskripsi_barang());
                mIntent.putExtra("ukuran", listData.get(position).getUkuran());
                mIntent.putExtra("warna", listData.get(position).getWarna());
                view.getContext().startActivity(mIntent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class HolderData extends RecyclerView.ViewHolder {
        TextView nama,jenis;
        ImageView gambar;
        CardView cardView;

        public HolderData(@NonNull View itemView) {
            super(itemView);
            gambar = itemView.findViewById(R.id.gbrcari);
            jenis = itemView.findViewById(R.id.jnscari);
            nama = itemView.findViewById(R.id.nmbjcari);
            cardView = itemView.findViewById(R.id.cardcari);

        }
    }
}

