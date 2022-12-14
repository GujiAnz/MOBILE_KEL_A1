package com.example.store;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterBarang extends RecyclerView.Adapter<AdapterBarang.HolderData> {
    Context ctx;
    List<DataBarang> listData;

    public AdapterBarang(Context ctx, List<DataBarang> listData) {
        this.ctx = ctx;
        this.listData = listData;
    }

    @NonNull
    @Override
    public AdapterBarang.HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(ctx).inflate(R.layout.item_adapter_baju, parent, false);
//        HolderData holder = new HolderData(layout);
        return new HolderData(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, @SuppressLint("RecyclerView") int position) {
        DataBarang db = listData.get(position);

        holder.tvJenis.setText(String.valueOf(db.getNama_barang()));
        holder.tvHarga.setText(String.valueOf(db.getHarga_jual()));
        Picasso.get().load(Koneksi.gambar+listData.get(position).getGbr_produk()).into(holder.ivIcon);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent =  new Intent(view.getContext(), deskripsibarang.class);
                mIntent.putExtra("id_barang", listData.get(position).getId_barang());
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
        TextView tvId, tvJenis,tvNama,tvHarga, tvStok;
        ImageView ivIcon;
        CardView cardView;

        public HolderData(@NonNull View itemView) {
            super(itemView);
            ivIcon = itemView.findViewById(R.id.id_adapter_img);
            tvJenis = itemView.findViewById(R.id.id_adapter_nama_baju);
            tvHarga = itemView.findViewById(R.id.id_adapter_harga_baju);
            cardView = itemView.findViewById(R.id.card);

        }
    }
}
