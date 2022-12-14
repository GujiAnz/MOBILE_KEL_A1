package com.example.store;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseKeranjang{

	@SerializedName("pesan")
	private String pesan;

	@SerializedName("data")
	private List<DataKeranjang> data;

	@SerializedName("kode")
	private int kode;

	public void setPesan(String pesan){
		this.pesan = pesan;
	}

	public String getPesan(){
		return pesan;
	}

	public void setData(List<DataKeranjang> data){
		this.data = data;
	}

	public List<DataKeranjang> getData(){
		return data;
	}

	public void setKode(int kode){
		this.kode = kode;
	}

	public int getKode(){
		return kode;
	}
}