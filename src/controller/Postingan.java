/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.*;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.StageStyle;
import model.DataPostingan;
import model.DataPostinganList;
import model.DataUser;

/**
 *
 * @author ASUS
 */
public class Postingan implements Initializable {
    ObservableList listKategori = FXCollections.observableArrayList();
    ObservableList listStatus = FXCollections.observableArrayList();
    DataUser duO = new DataUser();
    XStream xstream = new XStream(new StaxDriver());
    
    @FXML
    private ChoiceBox<String> pilihKategori;
    
    @FXML
    private ChoiceBox<String> pilihStatus;
    
    @FXML
    private TextField judulPostingan;
    
    @FXML
    private TextField kontak;
    
    @FXML
    private TextArea deskripsiIde;
    
    @FXML
    private Label label = new Label();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadData();
        loadData2();
    }
    
    @FXML
    public void loadData() {
        listKategori.clear();
        listKategori.removeAll(listKategori);
        String a = "Kuliner";
        String b = "Fashion";
        String c = "Agribisnis";
        listKategori.addAll(a,b,c);
        pilihKategori.getItems().addAll(listKategori);
    }
    
    @FXML
    public void loadData2() {
        listKategori.clear();
        listStatus.removeAll(listStatus);
        String a2 = "Tersedia";
        String b2 = "Ekesekusi";
        String c2 = "Tertutup";
        listStatus.addAll(a2,b2,c2);
        pilihStatus.getItems().addAll(listStatus);
    }
    
    @FXML
    public void kirimPostingan(ActionEvent event) throws IOException {
        DataPostingan da = new DataPostingan();
        DataPostinganList dal = new DataPostinganList();
        da.setJudul(judulPostingan.getText());
        da.setKategori(pilihKategori.getSelectionModel().getSelectedItem());
        da.setDeskripsi(deskripsiIde.getText());
        da.setStatus(pilihStatus.getSelectionModel().getSelectedItem());
        da.setKontak(kontak.getText());
        readUser();
        
        if(pilihKategori.getSelectionModel().isEmpty()){
            label.setText("Kategori ide tidak boleh kosong");
        }else if(pilihStatus.getSelectionModel().isEmpty()){
            label.setText("Status ide tidak boleh kosong");
        }else if(judulPostingan.getText().equals("")){
            label.setText("Judul ide tidak boleh kosong");
        }else if(deskripsiIde.getText().equals("")){
            label.setText("Deskripsi ide tidak boleh kosong");
        }else{
            dal.addData(judulPostingan.getText(), pilihKategori.getSelectionModel().getSelectedItem(), deskripsiIde.getText(), pilihStatus.getSelectionModel().getSelectedItem(), duO.getUserName(), kontak.getText());
            pilihKategori.getSelectionModel().clearSelection();
            pilihStatus.getSelectionModel().clearSelection();
            listKategori.clear();
            listStatus.clear();
            judulPostingan.setText("");
            deskripsiIde.setText("");
            kontak.setText("");
            label.setText("Postingan terkirim!");
        }
    }
    
    void readUser(){

        FileInputStream input = null;

        try {
            input = new FileInputStream("online.xml");

            int isi;
            char charnya;
            String stringnya;
            stringnya ="";

            while ((isi = input.read()) != -1) {
                charnya= (char) isi;
                stringnya = stringnya + charnya;
            }

            duO = (DataUser) xstream.fromXML(stringnya);

        }

        catch (Exception e){
            System.err.println("test: "+e.getMessage());
        }

        finally{
            if(input != null){
                try{
                    input.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

