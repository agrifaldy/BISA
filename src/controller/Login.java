/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.FileOutputStream;
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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.io.FileInputStream;
import java.lang.reflect.Array;
import java.util.Arrays;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import model.DataUser;
import model.DataUserList;

/**
 *
 * @author gry
 */
public class Login implements Initializable {

    @FXML
    private Button button1;
    @FXML
    private Button button;
    
    @FXML
    private TextField uName = new TextField();
    
    @FXML
    private PasswordField pass = new PasswordField();
    
    @FXML
    private TextField uName1 = new TextField();
    
    @FXML
    private TextField nama = new TextField();
    
    @FXML
    private PasswordField pass1 = new PasswordField();
    
    @FXML
    private Label label = new Label();
    
    @FXML
    private Label label2 = new Label();
    
    @FXML
    private TextField usia = new TextField();
    
    @FXML
    private RadioButton radioLaki = new RadioButton();
    
    @FXML
    private RadioButton radioWanita = new RadioButton();
    
    DataUser duO = new DataUser();
    XStream xstream = new XStream(new StaxDriver());
    
    @FXML
    public void loginButton(ActionEvent event) throws IOException {
        Parent login = FXMLLoader.load(getClass().getResource("/view/Nav.fxml"));
        readUser();
        Iterator<DataUser> itr;
        DataUser du = new DataUser();
        DataUserList dul = new DataUserList();
        List<DataUser> data= new ArrayList();
        //System.out.println(uName.getText());
        dul.getReadData();
        data = (dul.getReadData());
        itr = data.iterator();
        
        while(itr.hasNext() == true){
            DataUser du1 = itr.next();
            
            if(uName.getText().equals(du1.getUserName()) && pass.getText().equals(du1.getPassword())){
                //dul.addDataLogin(uName1.getText(), pass1.getText());
                duO.setUserName(uName.getText());
                saveUserOnline();
                Scene scene = new Scene(login);
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(scene);
                window.show();
            }else if(uName.getText().equals("") && pass.getText().equals("")){
                label2.setText("Data kosong"); 
            }
            else if(!uName.getText().equals(du1.getUserName()) && pass.getText().equals(du1.getPassword())){
            label2.setText("Username salah!"); 
            }
            else if (uName.getText().equals(du1.getUserName()) && !pass.getText().equals(du1.getPassword())){
            label2.setText("Password salah!"); 
            }
            else if(uName.getText().equals("") ){
            label2.setText("Username anda kosong!");
            }
            else if(pass.getText().equals("")){
            label2.setText("Password anda kosong!");
            }
            else if (!uName.getText().equals(du1.getUserName()) && !pass.getText().equals(du1.getPassword())){
            label2.setText("Data yang dimasukkan tidak ada"); 
            }
        }
    }
      
    @FXML
    public void signUpButton(ActionEvent event) throws IOException{
        DataUser du = new DataUser();
        DataUserList dul = new DataUserList();
        List<DataUser> data= new ArrayList();
        Iterator<DataUser> itr;
        dul.getReadData();
        data = (dul.getReadData());
        itr = data.iterator();
        
        if(itr.hasNext() == true){
            DataUser du1 = itr.next();
            if(uName1.getText().equals(du1.getUserName())){
                label.setText("Username sudah ada");
            }else if(nama.getText().equals("")&& uName1.getText().equals(" ")&& pass1.getText().equals("") && usia.getText().equals("")){
                label.setText("Data harus diisi tidak boleh kosong!!");
            }else if(nama.getText().equals("")){
                label.setText("Nama tidak boleh kosong");   
            }else if(uName1.getText().equals("")){
                label.setText("Username tidak boleh kosong");   
            }else if(pass1.getText().equals("")){
                label.setText("Password tidak boleh kosong");      
            }else if(usia.getText().equals("")){
                label.setText("Umur tidak boleh kosong");
            }else if(!radioLaki.isSelected() && !radioWanita.isSelected()){
                    label.setText("Jenis kelamin harap dipilih salah satu");
            }else if(uName1.getText()!=(du1.getUserName())){
                String jenisKelamin= "";
                du.setUserName(uName1.getText());
                du.setPassword(pass1.getText());
                du.setNama(nama.getText());
                du.setUsia(usia.getText());
                if(radioLaki.isSelected()){
                    jenisKelamin = "Laki-laki";
                    du.setgender(jenisKelamin);
                    dul.addData(nama.getText(), uName1.getText(), pass1.getText(), usia.getText(), jenisKelamin);
                    label.setText("Akun anda berhasil terdaftar!");
                }else if(radioWanita.isSelected()){
                    jenisKelamin = "Perempuan";
                    du.setgender(jenisKelamin);
                    dul.addData(nama.getText(), uName1.getText(), pass1.getText(), usia.getText(), jenisKelamin);
                    label.setText("Akun anda berhasil terdaftar!");
                }else{
                    label.setText("Harap isi data anda");
                }
                
            }
            
        }
        
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        readUser();
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