package com.example.store;

public class ModelBaju {
    private String namaBaju;
    private int hargaBaju;
    private int bajuImg;

    public ModelBaju(String namaBaju, int hargaBaju, int bajuImg) {
        this.namaBaju = namaBaju;
        this.hargaBaju = hargaBaju;
        this.bajuImg = bajuImg;
    }

    public String getNamaBaju() {
        return namaBaju;
    }

    public void setNamaBaju(String namaBaju) {
        this.namaBaju = namaBaju;
    }

    public int getHargaBaju() {
        return hargaBaju;
    }

    public void setHargaBaju(int hargaBaju) {
        this.hargaBaju = hargaBaju;
    }

    public int getBajuImg() {
        return bajuImg;
    }

    public void setBajuImg(int bajuImg) {
        this.bajuImg = bajuImg;
    }
}
