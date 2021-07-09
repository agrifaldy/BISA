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

public class Agribisnis implements Initializable {
    private DataPostinganList dpl;
    ObservableList list = FXCollections.observableArrayList();
    
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tb.setEditable(false);
        tb_judulPostingan.setCellFactory(TextFieldTableCell.forTableColumn());
        tb_deskripsiPostingan.setCellFactory(TextFieldTableCell.forTableColumn());
        tb_status.setCellFactory(TextFieldTableCell.forTableColumn());
        tb_user.setCellFactory(TextFieldTableCell.forTableColumn());
        tb_kontak.setCellFactory(TextFieldTableCell.forTableColumn());
                
        dpl = new DataPostinganList();
        DataPostingan dp = new DataPostingan();
        dpl.loadXMLFile();
        dpl.readData();
        tb.setItems(dpl.get().filtered(kuliner()));
        
        tb_judulPostingan.setCellValueFactory(cellData -> cellData.getValue().judulPostingan());
        tb_deskripsiPostingan.setCellValueFactory(cellData -> cellData.getValue().deskripsiPostingan());
        tb_status.setCellValueFactory(cellData -> cellData.getValue().Status());
        tb_user.setCellValueFactory(cellData -> cellData.getValue().userPost());
        tb_kontak.setCellValueFactory(cellData -> cellData.getValue().Kontak());
        
    }
    
    //sekeleksi data
    public static Predicate<DataPostinganProperty> kuliner(){
       return p -> p.getKategori().equals("Agribisnis");
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
            dap.setKontak(da1.getKontak());
        }
    }
    
    public void loadData() {
        list.removeAll(list);
        String a = "Kuliner";
        String b = "Fashion";
        list.addAll(a,b);
        pilihanUbah.getItems().addAll(list);
    }
    
    public void Beranda(ActionEvent event) throws IOException {
        Parent Beranda = FXMLLoader.load(getClass().getResource("/view/Nav.fxml"));
                Scene scene = new Scene(Beranda);
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(scene);
                window.show();
    }
}