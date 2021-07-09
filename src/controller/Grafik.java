/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
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
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.StageStyle;
import model.DataPostingan;
import model.DataPostinganList;
import model.DataUser;
import model.DataUserList;

/**
 *
 * @author ASUS
 */
public class Grafik implements Initializable {
    
    ObservableList<PieChart.Data> dataPiePostingan = FXCollections.observableArrayList();
    //ObservableList<PieChart.Data> dataPieGender = FXCollections.observableArrayList();
    
    @FXML
    private BarChart<?, ?> barChart;
    
    @FXML
    private PieChart pieChartPostingan;
    
    @FXML
    private PieChart pieChartGender;
    
    @FXML
    private ChoiceBox choiceJumlah = new ChoiceBox();
    
    @FXML
    private ChoiceBox choiceUsia = new ChoiceBox();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        DataPostingan da = new DataPostingan();
        DataPostinganList dataPostingan = new DataPostinganList();
        dataPostingan.readData();
        dataPostingan.loadXMLFile();
        
        //XYChart.Series dataSeries = new XYChart.Series();
        Iterator<DataPostingan> itr;
        dataPostingan.setFromArray(dataPostingan.getArray());
        
        List<DataPostingan> data = new ArrayList();
        data = dataPostingan.getReadData();
        
        itr = data.iterator();
        int kuliner, fashion, agribisnis;
        kuliner=0;
        fashion=0;
        agribisnis=0;
        //System.out.println(da.getJudul());
        
        while(itr.hasNext() == true){
            DataPostingan dp1 = itr.next();
                //System.out.println(dp1.getA());
                if(dp1.getKategori().equals(dp1.getA())){
                    kuliner++;
                }else if(dp1.getKategori().equals(dp1.getB())){
                    fashion++;
                }else if(dp1.getKategori().equals(dp1.getC())){
                    agribisnis++;
                }
        }
        
        XYChart.Series dataSeries = new XYChart.Series<>();
        dataSeries.getData().add(new XYChart.Data("Kuliner", kuliner));
        dataSeries.getData().add(new XYChart.Data("Fashion", fashion));
        dataSeries.getData().add(new XYChart.Data("Agribisnis", agribisnis));
        dataSeries.setName("Jumlah Postingan");
        
       
        barChart.getData().addAll(dataSeries);
        
        double total = kuliner+fashion+agribisnis;
        double persentaseKuliner = (kuliner/total)*100;
        double persentaseFashion = (fashion/total)*100;
        double persentaseAgribisnis = (agribisnis/total)*100;
        
        
        dataPiePostingan.add(new PieChart.Data("Kuliner("+String.format("%.2f", persentaseKuliner)+"%)", kuliner));
        dataPiePostingan.add(new PieChart.Data("Fashion("+String.format("%.2f", persentaseFashion)+"%)", fashion));
        dataPiePostingan.add(new PieChart.Data("Agribisnis("+String.format("%.2f", persentaseAgribisnis)+"%)", agribisnis));
        
        pieChartPostingan.setData(dataPiePostingan);  
        
        
        
        
    }
    
    
    
}

