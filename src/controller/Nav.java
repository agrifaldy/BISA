/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import model.DataUser;

/**
 *
 * @author ASUS
 */
public class Nav implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    public BorderPane mainPane;
    
    @FXML
    private Line line;
    
    DataUser duO = new DataUser();
    XStream xstream = new XStream(new StaxDriver());
    
    
    @FXML
    private void Postingan(ActionEvent event) {
        Scene object = new Scene();
        Pane halaman = object.getPane("Beranda");
        mainPane.setCenter(halaman);
        line.setVisible(true);
        line.setLayoutY(114);
    }
    
    @FXML
    private void Agribisnis(ActionEvent event) {
        Scene object = new Scene();
        Pane halaman = object.getPane("Agribisnis");
        mainPane.setCenter(halaman);
    }
    
    @FXML
    private void Fashion(ActionEvent event) {
        Scene object = new Scene();
        Pane halaman = object.getPane("Fashion");
        mainPane.setCenter(halaman);
    }
    
    @FXML
    private void Kuliner(ActionEvent event) {
        Scene object = new Scene();
        Pane halaman = object.getPane("Kuliner");
        mainPane.setCenter(halaman);
    }
    
    @FXML
    private void PostingIde(ActionEvent event) {
        Scene object = new Scene();
        Pane halaman = object.getPane("Postingan");
        mainPane.setCenter(halaman);
        line.setVisible(true);
        line.setLayoutY(213);
    }
    
    @FXML
    private void Grafik(ActionEvent event) {
        Scene object = new Scene();
        Pane halaman = object.getPane("Grafik");
        mainPane.setCenter(halaman);
        line.setVisible(true);
        line.setLayoutY(316);
    }
    
    @FXML
    private void EditIde(ActionEvent event) {
        Scene object = new Scene();
        Pane halaman = object.getPane("EditPostingan");
        mainPane.setCenter(halaman);
        line.setVisible(true);
        line.setLayoutY(420);
    }
    @FXML
    public void Artikel(ActionEvent event) throws IOException {
        Parent beranda = FXMLLoader.load(getClass().getResource("/view/Artikel.fxml"));
                javafx.scene.Scene scene = new javafx.scene.Scene(beranda);
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(scene);
                window.show();
                duO.setUserName(duO.getUserName());
    }
    @FXML
    public void Keluar(ActionEvent event) throws IOException {
        Parent beranda = FXMLLoader.load(getClass().getResource("/view/Login.fxml"));
                javafx.scene.Scene scene = new javafx.scene.Scene(beranda);
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(scene);
                window.show();
                duO.setUserName(duO.getUserName());
                saveUserOnline();
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        readUser();
        label.setText("Selamat datang, "+duO.getUserName());
        Scene object = new Scene();
        Pane halaman = object.getPane("Wellcome");
        mainPane.setCenter(halaman);
        line.setVisible(false);
    }

    private void saveUserOnline() {
        
        String xml = xstream.toXML(duO);
        
        FileOutputStream test = null;
        try {
            test = new FileOutputStream("online.xml");
            byte[] bytes = xml.getBytes("UTF-8");
            test.write(bytes);
        }
        catch (Exception e){
            System.err.println("Perhatian: "+e.getMessage());
        }
        finally{
            if (test != null){
                try{
                    test.close();
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }  
    
    
}
