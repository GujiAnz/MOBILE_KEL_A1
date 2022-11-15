package com.example.store;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterBaju  extends RecyclerView.Adapter<AdapterBaju.ViewHolder> {

    List<ModelBaju> listBaju;

    public AdapterBaju(List<ModelBaju> listBaju) {
        this.listBaju = listBaju;
    }

    @NonNull
    @Override
    public AdapterBaju.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vi = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_adapter_baju, parent,false);
        return new ViewHolder(vi);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterBaju.ViewHolder holder, int position) {
        holder.namaItem.setText(listBaju.get(position).getNamaBaju());
        holder.hargaItem.setText(String.valueOf(listBaju.get(position).getHargaBaju()));
        holder.gambarItem.setImageResource(listBaju.get(position).getBajuImg());
    }

    @Override
    public int getItemCount() {
        return listBaju.size();
    }

    public class ViewHolder  extends RecyclerView.ViewHolder{
        TextView namaItem , hargaItem;
        ImageView gambarItem;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            namaItem = itemView.findViewById(R.id.id_adapter_nama_baju);
            hargaItem = itemView.findViewById(R.id.id_adapter_harga_baju);
            gambarItem = itemView.findViewById(R.id.id_adapter_img);
        }
    }
}
