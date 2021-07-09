package model;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class DataPostinganList {

    private ObservableList<DataPostinganProperty> list;
    private String extFile;
    
    public DataPostinganList() {
        list = FXCollections.observableArrayList();
        extFile = "dataPostinganAR.xml";
    }
    
    public ObservableList<DataPostinganProperty> get() {
        return list;
    }
    
    
    public void saveData(){
        List<DataPostingan> data= new ArrayList();
        XStream xstream = new XStream(new StaxDriver());
        
        String xml = xstream.toXML(data);

        FileOutputStream coba = null;
           try {
            coba = new FileOutputStream("dataPostingan.xml");
            byte[] bytes = xml.getBytes("UTF-8");
           coba.write(bytes);
            coba.close();
         } catch (Exception e){
             System.err.println("Perhatian: "+e.getMessage());
         }
    }
    
    public void readData(){
        List<DataPostingan> data= new ArrayList();
        
        XStream xstream = new XStream(new StaxDriver());
        FileInputStream cobi = null;
        try {
            cobi = new FileInputStream("dataPostingan.xml");

            int isi;
            char charnya;
            String stringnya;

            stringnya ="";
            while ((isi = cobi.read()) != -1) {
                charnya= (char) isi;
                stringnya = stringnya + charnya;
            }    

          data = (List<DataPostingan>) xstream.fromXML(stringnya);
        }
        catch (Exception e){
            System.err.println("test: "+e.getMessage());
        }
        finally{
          if(cobi == null){
              try{
                  cobi.close();
              }catch (IOException e) {
                  e.printStackTrace();
              }
          }      
        }
        
    }
    
    public void addData(String judul, String kategori, String deskripsi, String status, String userPost, String kontak){
        readData();
        loadXMLFile();
        ArrayList<DataPostingan> arrayList = new ArrayList<DataPostingan>(Arrays.asList(getArray()));
        List<DataPostingan> data= new ArrayList();
        data = arrayList;
        XStream xstream = new XStream(new StaxDriver());
        FileInputStream cobi = null;
        try {
            cobi = new FileInputStream("dataPostingan.xml");

            int isi;
            char charnya;
            String stringnya;

            stringnya ="";
            while ((isi = cobi.read()) != -1) {
                charnya= (char) isi;
                stringnya = stringnya + charnya;
            }    

          data = (List<DataPostingan>) xstream.fromXML(stringnya);
        }
        catch (Exception e){
            System.err.println("test: "+e.getMessage());
        }
        finally{
          if(cobi == null){
              try{
                  cobi.close();
              }catch (IOException e) {
                  e.printStackTrace();
              }
          }      
        }
     
        data.add(new DataPostingan(judul, kategori, deskripsi, status, userPost, kontak));
        DataPostingan[] array = data.toArray(new DataPostingan[data.size()]);  

        for(int i = 0; i < list.size(); i++) {
            String judulA = list.get(i).getJudul();
            String instansiA = list.get(i).getKategori();
            String deskripsiA = list.get(i).getDeskripsi();
            String statusA = list.get(i).getStatus();
            String userPostA = list.get(i).getUserPost();
            String kontakA = list.get(i).getKontak();
            array[i] = new DataPostingan(judulA, instansiA, deskripsiA, statusA, userPostA, kontakA);
        }
        
        XStream xs = new XStream(new StaxDriver());
        String xml1 = xs.toXML(array);

        try{
            FileOutputStream output = new FileOutputStream(extFile);
            byte[] bytes = xml1.getBytes();
            output.write(bytes);
            output.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        String xml = xstream.toXML(data);
        FileOutputStream coba = null;
        try {
        coba = new FileOutputStream("dataPostingan.xml");
        byte[] bytes = xml.getBytes("UTF-8");
        coba.write(bytes);
        coba.flush();
        coba.close();
         } catch (Exception e){
               System.err.println("Perhatian: "+e.getMessage());
           }

    }
    
    public List<DataPostingan> getReadData(){
        ArrayList<DataPostingan> arrayList = new ArrayList<DataPostingan>(Arrays.asList(getArray()));
        List<DataPostingan> data= new ArrayList();
        data = arrayList;
        XStream xstream = new XStream(new StaxDriver());
        FileInputStream cobi = null;
        try {
            cobi = new FileInputStream("dataPostingan.xml");

            int isi;
            char charnya;
            String stringnya;

            stringnya ="";
            while ((isi = cobi.read()) != -1) {
                charnya= (char) isi;
                stringnya = stringnya + charnya;
            }    
            data = (List<DataPostingan>) xstream.fromXML(stringnya);
        }
        catch (Exception e){
            System.err.println("test: "+e.getMessage());
        }
        finally{
          if(cobi == null){
              try{
                  cobi.close();
              }catch (IOException e) {
                  e.printStackTrace();
              }
          }      
        }
        
        return data;
    } 
    
    public void setFromArrayL(List<DataPostingan> array) {
        list = FXCollections.observableArrayList();
        DataPostinganList dal = new DataPostinganList();
        List<DataPostingan> data = new ArrayList();
        for(DataPostingan da : array) {
            list.add(new DataPostinganProperty(da.getJudul(), da.getKategori(), da.getDeskripsi(), da.getStatus(), da.getUserPost(), da.getKontak()));
        }
    }
    
    
    //Ganti Array
    
    
    public void setFromArray(DataPostingan[] array) {
        list = FXCollections.observableArrayList();
        

        for(DataPostingan da : array) {
            list.add(new DataPostinganProperty(da.getJudul(), da.getKategori(), da.getDeskripsi(), da.getStatus(), da.getUserPost(), da.getKontak()));
        }
    }

    public void loadXMLFile() {
        //readData();
        try {
            XStream xs = new XStream(new StaxDriver());
            FileInputStream in = new FileInputStream(extFile);
            String s = "";
            int c = in.read();
            while (c != -1) {
                s += (char) c;
                c = in.read();
            }
           
            DataPostingan[] array = (DataPostingan[]) xs.fromXML(s);
            this.setFromArray(array);
        } catch (Exception e) {
            e.printStackTrace();
        }
 
    }

    public DataPostingan[] getArray() {
        DataPostingan[] array = new DataPostingan[list.size()];
        for(int i = 0; i < list.size(); i++) {
            String judul = list.get(i).getJudul();
            String kategori = list.get(i).getKategori();
            String deskripsi = list.get(i).getDeskripsi();
            String status = list.get(i).getStatus();
            String userPost = list.get(i).getUserPost();
            String kontak = list.get(i).getKontak();
            array[i] = new DataPostingan(judul, kategori, deskripsi, status, userPost, kontak);
        }
        

        return array;
    }

    public void saveXMLFile() {
        readData();
        DataPostingan[] array = this.getArray();
        XStream xs = new XStream(new StaxDriver());
        String xml = xs.toXML(array);
        ArrayList<DataPostingan> arrayList = new ArrayList<DataPostingan>(Arrays.asList(array));

        try{
            FileOutputStream output = new FileOutputStream(extFile);
            byte[] bytes = xml.getBytes();
            output.write(bytes);
            output.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        String xml1 = xs.toXML(arrayList);

        FileOutputStream coba = null;
           try {
            coba = new FileOutputStream("dataPostingan.xml");
            byte[] bytes = xml.getBytes("UTF-8");
           coba.write(bytes);
            coba.close();
         } catch (Exception e){
             System.err.println("Perhatian: "+e.getMessage());
         }
        
        
    }
    

    

}


