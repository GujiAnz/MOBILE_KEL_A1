package com.example.store;

public class modelpost {
    private String email_pembeli;
    private String password_pembeli;
    private String nama_pembeli;
    private String jenis_kelamin;
    private  String no_telp;


    public String getEmail_pembeli() {
        return email_pembeli;
    }

    public void setEmail_pembeli(String email_pembeli) {
        this.email_pembeli = email_pembeli;
    }

    public String getPassword_pembeli() {
        return password_pembeli;
    }

    public void setPassword_pembeli(String password_pembeli) {
        this.password_pembeli = password_pembeli;
    }

    public String getNama_pembeli() {
        return nama_pembeli;
    }

    public void setNama_pembeli(String nama_pembeli) {
        this.nama_pembeli = nama_pembeli;
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public String getNo_telp() {
        return no_telp;
    }

    public void setNo_telp(String no_telp) {
        this.no_telp = no_telp;
    }

    public modelpost(String email_pembeli, String password_pembeli, String nama_pembeli,String jenis_kelamin,String no_telp){

        this.email_pembeli= email_pembeli;
        this.password_pembeli = password_pembeli;
        this.nama_pembeli = nama_pembeli;
        this.jenis_kelamin = jenis_kelamin;
        this.no_telp = no_telp;


    }
    public  modelpost(){

    }
}
