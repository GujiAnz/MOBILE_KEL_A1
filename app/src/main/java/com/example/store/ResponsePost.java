package com.example.store;

import java.util.List;

public class ResponsePost {
    private byte kode;
    private List<model> data;

    public byte getKode() {
        return kode;
    }

    public void setKode(byte kode) {
        this.kode = kode;
    }

    public List<model> getData() {
        return data;
    }

    public void setData(List<model> data) {
        this.data = data;
    }

    public ResponsePost(byte kode, List<model> data) {
        this.kode = kode;
        this.data = data;
    }

    public ResponsePost() {
    }
}
