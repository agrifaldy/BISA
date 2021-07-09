package model;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataPostingan {
    private String judul;
    private String kategori;
    private String deskripsi;
    private String status;
    private String userPost;
    private String kontak;

   
    public DataPostingan(String judul, String kategori, String deskripsi, String status, String userPost, String kontak) {
        this.judul = judul;
        this.kategori = kategori;
        this.deskripsi = deskripsi;
        this.status = status;
        this.userPost = userPost;
        this.kontak = kontak;
    }
    
    public String getA(){
        String a = "Kuliner";
        return a;
    }
    
    public String getB(){
        String b = "Fashion";
        return b;
    }
    
    public String getC(){
        String c = "Agribisnis";
        return c;
    }
    
    public String getA2(){
        String a2 = "Tersedia";
        return a2;
    }
    
    public String getB2(){
        String b2 = "Eksekusi";
        return b2;
    }
    
    public String getC2(){
        String c2 = "Tertutup";
        return c2;
    }
    
    
    public DataPostingan() {}
            
    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }   
    
    public String getUserPost() {
        return userPost;
    }

    public void setUserPost(String userPost) {
        this.userPost = userPost;
    }
    
    public String getKontak() {
        return kontak;
    }

    public void setKontak(String kontak) {
        this.kontak = kontak;
    }
    
}
