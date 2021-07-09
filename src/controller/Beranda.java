/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.StageStyle;
import model.DataUser;
import controller.Login;
import controller.Nav;
import java.io.FileInputStream;
import javafx.scene.layout.Pane;

/**
 *
 * @author gry
 */
public class Beranda implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private Button bKuliner;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    public void Kuliner(ActionEvent event) throws IOException {
        Parent kuliner = FXMLLoader.load(getClass().getResource("/view/Kuliner.fxml"));
                Scene scene = new Scene(kuliner);
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(scene);
                window.show();
    }
    
    @FXML
    public void Fashion(ActionEvent event) throws IOException {
        Parent kuliner = FXMLLoader.load(getClass().getResource("/view/Fashion.fxml"));
                Scene scene = new Scene(kuliner);
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(scene);
                window.show();
    }
    
    @FXML
    public void Agribisnis(ActionEvent event) throws IOException {
        Parent kuliner = FXMLLoader.load(getClass().getResource("/view/Agribisnis.fxml"));
                Scene scene = new Scene(kuliner);
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(scene);
                window.show();
    }
    
}

