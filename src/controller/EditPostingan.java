package controller;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import javafx.beans.property.SimpleStringProperty;
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
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.StageStyle;
import model.DataPostingan;
import model.DataPostinganList;
import model.DataPostinganProperty;
import model.DataUser;
import model.DataUserList;

public class EditPostingan implements Initializable {
    private DataPostinganList dpl;
    ObservableList list = FXCollections.observableArrayList();
    
    
    DataUser duO = new DataUser();
    XStream xstream = new XStream(new StaxDriver());
    
    
    @FXML
    private ChoiceBox<String> pilihanUbah;
    
    @FXML
    private TableView<DataPostinganProperty> tb;
    
    @FXML
    private TableColumn<DataPostinganProperty, String> tb_judulPostingan;
    
    @FXML
    private TableColumn<DataPostinganProperty, String> tb_kategori;
    
    @FXML
    private TableColumn<DataPostinganProperty, String> tb_deskripsiPostingan;
    
    @FXML
    private TableColumn<DataPostinganProperty, String> tb_status;
    
    @FXML
    private TableColumn<DataPostinganProperty, String> tb_user;
    
    @FXML
    private TableColumn<DataPostinganProperty, String> tb_kontak;
            
    @FXML
    private Button deleteButton;
    
    @FXML
    private Label label;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        readUser();
        tb.setEditable(true);
        tb_judulPostingan.setCellFactory(TextFieldTableCell.forTableColumn());
        tb_kontak.setCellFactory(TextFieldTableCell.forTableColumn());
        tb_kategori.setCellFactory(TextFieldTableCell.forTableColumn());
        tb_deskripsiPostingan.setCellFactory(TextFieldTableCell.forTableColumn());
        tb_status.setCellFactory(TextFieldTableCell.forTableColumn());
        
        dpl = new DataPostinganList();
        
        DataPostingan dp = new DataPostingan();
        dpl.loadXMLFile();
        dpl.readData();
        tb.setItems(dpl.get());
        tb.setItems(dpl.get().filtered(pengguna()));
        
        tb_judulPostingan.setCellValueFactory(cellData -> cellData.getValue().judulPostingan());
        tb_kontak.setCellValueFactory(cellData -> cellData.getValue().Kontak());
        tb_kategori.setCellValueFactory(cellData -> cellData.getValue().Kategori());
        tb_deskripsiPostingan.setCellValueFactory(cellData -> cellData.getValue().deskripsiPostingan());
        tb_status.setCellValueFactory(cellData -> cellData.getValue().Status());
    }
    
    //sekeleksi data
    public Predicate<DataPostinganProperty> pengguna(){
       return p -> duO.getUserName().equals(p.getUserPost());
    }
    
    //delete data fix
    public void delete(){
        tb.setItems(dpl.get());
        DataPostinganProperty dpp = tb.getSelectionModel().getSelectedItem();
        tb.getItems().remove(dpp);
        dpl.saveXMLFile();
        tb.setItems(dpl.get().filtered(pengguna()));
        if(tb.getSelectionModel().getSelectedItem() == null){
           label.setText("Pilih data yang ingin dihapus terlebih dahulu"); 
        }else{
           label.setText("Data berhasil dihapus"); 
        }
    }
    
    //update data goks
    public void editJudul(TableColumn.CellEditEvent<DataPostinganProperty, String>judulEdit){
        DataPostinganProperty dpp = tb.getSelectionModel().getSelectedItem();
        dpp.setJudul(judulEdit.getNewValue());
        dpl.saveXMLFile();
    }
    
    public void editKategori(TableColumn.CellEditEvent<DataPostinganProperty, String>kategoriEdit){
        DataPostinganProperty dpp = tb.getSelectionModel().getSelectedItem();
        dpp.setKategori(kategoriEdit.getNewValue());
        dpl.saveXMLFile();
    }
    
    public void editDeskripsi(TableColumn.CellEditEvent<DataPostinganProperty, String>deskripsiEdit){
        DataPostinganProperty dpp = tb.getSelectionModel().getSelectedItem();
        dpp.setDeskripsi(deskripsiEdit.getNewValue());
        dpl.saveXMLFile();
    }
    
    public void editKontak(TableColumn.CellEditEvent<DataPostinganProperty, String>kontakEdit){
        DataPostinganProperty dpp = tb.getSelectionModel().getSelectedItem();
        dpp.setKontak(kontakEdit.getNewValue());
        dpl.saveXMLFile();
    }
    
    public void editStatus(TableColumn.CellEditEvent<DataPostinganProperty, String>statusEdit){
        DataPostinganProperty dpp = tb.getSelectionModel().getSelectedItem();
        dpp.setStatus(statusEdit.getNewValue());
        dpl.saveXMLFile();
    }
    
    public void readData(){
        DataPostingan dp = new DataPostingan();
        DataPostinganList dpl = new DataPostinganList();
        Iterator<DataPostingan> itr;
        List<DataPostingan> data= new ArrayList();
        XStream xstream = new XStream(new StaxDriver());
        dpl.getReadData();
        data = dpl.getReadData();
        
        itr = data.iterator();
        while(itr.hasNext() == true){
            DataPostingan da1 = itr.next();
            DataPostinganProperty dap = new DataPostinganProperty();
            dap.setJudul(da1.getJudul());
            dap.setKategori(da1.getKategori());
            dap.setDeskripsi(da1.getDeskripsi());
            dap.setStatus(da1.getStatus());
            dap.setUserPost(da1.getUserPost());
        }
    }
    
    public void loadData() {
        list.removeAll(list);
        String a = "Kuliner";
        String b = "Fashion";
        list.addAll(a,b);
        pilihanUbah.getItems().addAll(list);
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