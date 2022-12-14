package com.example.store;

import com.google.gson.annotations.SerializedName;

public class DataKeranjang {

	@SerializedName("harga")
	private String harga;

	@SerializedName("nama_barang")
	private String namaBarang;

	@SerializedName("id")
	private String id;

	@SerializedName("gbr_produk")
	private String gbrProduk;

	@SerializedName("id_pembeli")
	private String idPembeli;

	public void setHarga(String harga){
		this.harga = harga;
	}

	public String getHarga(){
		return harga;
	}

	public void setNamaBarang(String namaBarang){
		this.namaBarang = namaBarang;
	}

	public String getNamaBarang(){
		return namaBarang;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setGbrProduk(String gbrProduk){
		this.gbrProduk = gbrProduk;
	}

	public String getGbrProduk(){
		return gbrProduk;
	}

	public void setIdPembeli(String idPembeli){
		this.idPembeli = idPembeli;
	}

	public String getIdPembeli(){
		return idPembeli;
	}
}