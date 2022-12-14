package com.example.store;

import com.google.gson.annotations.SerializedName;

public class Tesss{

	@SerializedName("data")
	private DataUser data;

	@SerializedName("kode")
	private int kode;

	@SerializedName("message")
	private String message;

	public void setData(DataUser data){
		this.data = data;
	}

	public DataUser getData(){
		return data;
	}

	public void setKode(int kode){
		this.kode = kode;
	}

	public int getKode(){
		return kode;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}
}