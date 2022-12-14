package com.example.store;

import com.google.gson.annotations.SerializedName;

public class DataUser {

	@SerializedName("nama_pembeli")
	private String namaPembeli;

	@SerializedName("email_pembeli")
	private String emailPembeli;

	@SerializedName("no_telp")
	private String noTelp;

	@SerializedName("jenis_kelamin")
	private String jenisKelamin;

	@SerializedName("id_pembeli")
	private String idPembeli;

	public void setNamaPembeli(String namaPembeli){
		this.namaPembeli = namaPembeli;
	}

	public String getNamaPembeli(){
		return namaPembeli;
	}

	public void setEmailPembeli(String emailPembeli){
		this.emailPembeli = emailPembeli;
	}

	public String getEmailPembeli(){
		return emailPembeli;
	}

	public void setNoTelp(String noTelp){
		this.noTelp = noTelp;
	}

	public String getNoTelp(){
		return noTelp;
	}

	public void setJenisKelamin(String jenisKelamin){
		this.jenisKelamin = jenisKelamin;
	}

	public String getJenisKelamin(){
		return jenisKelamin;
	}

	public void setIdPembeli(String idPembeli){
		this.idPembeli = idPembeli;
	}

	public String getIdPembeli(){
		return idPembeli;
	}
}