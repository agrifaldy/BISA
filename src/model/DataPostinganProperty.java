package model;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class DataPostinganProperty {
    private StringProperty judul;
    private StringProperty kategori;
    private StringProperty deskripsi;
    private StringProperty status;
    private StringProperty userPost;
    private StringProperty kontak;

    public DataPostinganProperty(String judul, String kategori, String deskripsi, String status, String userPost, String kontak) {
        this.judul = new SimpleStringProperty(judul);
        this.kategori = new SimpleStringProperty(kategori);
        this.deskripsi = new SimpleStringProperty(deskripsi);
        this.status = new SimpleStringProperty(status);
        this.userPost = new SimpleStringProperty(userPost);
        this.kontak = new SimpleStringProperty(kontak);
    }
    
    public DataPostinganProperty() {
        this("","","","","","");
    }
    public StringProperty judulPostingan() {
        return judul;
    }
    
    public StringProperty Kategori() {
        return kategori;
    }
    
    public StringProperty deskripsiPostingan() {
        return deskripsi;
    }
    
    public StringProperty Status() {
        return status;
    }
    
    public StringProperty userPost() {
        return userPost;
    }
    
    public StringProperty Kontak() {
        return kontak;
    }

   
    public String getJudul() {
        return this.judul.get();
    }

    public void setJudul(String judul) {
        this.judul.set(judul);
    }

    public String getKategori() {
        return this.kategori.get();
    }

    public void setKategori(String kategori) {
        this.kategori.set(kategori);
    }

    public String getDeskripsi() {
        return this.deskripsi.get();
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi.set(deskripsi);
    }
    
    public String getStatus() {
        return this.status.get();
    }

    public void setStatus(String status) {
        this.status.set(status);
    }
    
    public String getUserPost() {
        return this.userPost.get();
    }

    public void setUserPost(String userPost) {
        this.userPost.set(userPost);
    }
    
    public String getKontak() {
        return this.kontak.get();
    }

    public void setKontak(String kontak) {
        this.kontak.set(kontak);
    }
    
}
