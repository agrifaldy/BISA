package model;

import model.DataUser;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class DataUserList {
    
    private String nama;
    private String uName;
    private String password;
    private String usia;
    private String gender;

    
    public DataUserList(String nama, String uName, String password, String usia, String gender) {
        this.uName = nama;
        this.uName = uName;
        this.password = password;
        this.uName = usia;
        this.uName = gender;
    }

    public DataUserList() {}
    
    public void saveData(){
        List<DataUser> data= new ArrayList();
        XStream xstream = new XStream(new StaxDriver());
        String xml = xstream.toXML(data);
        FileOutputStream coba = null;
           try {
            coba = new FileOutputStream("dataUser.xml");
            byte[] bytes = xml.getBytes("UTF-8");
           coba.write(bytes);
           
            coba.close();
         } catch (Exception e){
             System.err.println("Perhatian: "+e.getMessage());
         }
    }
    
    public void saveDataOnline(){
        List<DataUser> data= new ArrayList();
        XStream xstream = new XStream(new StaxDriver());
        String xml = xstream.toXML(data);
        FileOutputStream coba = null;
           try {
            coba = new FileOutputStream("online.xml");
            byte[] bytes = xml.getBytes("UTF-8");
           coba.write(bytes);
           
            coba.close();
         } catch (Exception e){
             System.err.println("Perhatian: "+e.getMessage());
         }
    }
    
    
//    public void saveDataLogin(){
//        List<DataUser> data= new ArrayList();
//        XStream xstream = new XStream(new StaxDriver());
//        String xml = xstream.toXML(data);
//        FileOutputStream coba = null;
//           try {
//            coba = new FileOutputStream("userOnline.xml");
//            byte[] bytes = xml.getBytes("UTF-8");
//           coba.write(bytes);
//           
//            coba.close();
//         } catch (Exception e){
//             System.err.println("Perhatian: "+e.getMessage());
//         }
//    }
    
    public void readData(){
      List<DataUser> data= new ArrayList();
      XStream xstream = new XStream(new StaxDriver());
      FileInputStream cobi = null;
      try {
          cobi = new FileInputStream("dataUser.xml");
          int isi;
          char charnya;
          String stringnya;
          stringnya ="";
          while ((isi = cobi.read()) != -1) {
              charnya= (char) isi;
              stringnya = stringnya + charnya;
          }    
        data = (List<DataUser>) xstream.fromXML(stringnya);
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
    
    public void readDataOnline(){
      List<DataUser> data= new ArrayList();
      XStream xstream = new XStream(new StaxDriver());
      FileInputStream cobi = null;
      try {
          cobi = new FileInputStream("online.xml");
          int isi;
          char charnya;
          String stringnya;
          stringnya ="";
          while ((isi = cobi.read()) != -1) {
              charnya= (char) isi;
              stringnya = stringnya + charnya;
          }    
        data = (List<DataUser>) xstream.fromXML(stringnya);
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
    
//    public void readDataLogin(){
//      List<DataUser> data= new ArrayList();
//      XStream xstream = new XStream(new StaxDriver());
//      FileInputStream cobi = null;
//      try {
//          cobi = new FileInputStream("userOnline.xml");
//          int isi;
//          char charnya;
//          String stringnya;
//          stringnya ="";
//          while ((isi = cobi.read()) != -1) {
//              charnya= (char) isi;
//              stringnya = stringnya + charnya;
//          }    
//        data = (List<DataUser>) xstream.fromXML(stringnya);
//      }
//      catch (Exception e){
//          System.err.println("test: "+e.getMessage());
//      }
//      finally{
//        if(cobi == null){
//            try{
//                cobi.close();
//            }catch (IOException e) {
//                e.printStackTrace();
//            }
//        }      
//      }
//    }
    
    public  void addData(String nama1, String uName1, String pass1, String usia1, String gender1){
        readData();
        List<DataUser> data= new ArrayList();
        XStream xstream = new XStream(new StaxDriver());
        FileInputStream cobi = null;
        try {
            cobi = new FileInputStream("dataUser.xml");

            int isi;
            char charnya;
            String stringnya;

            stringnya ="";
            while ((isi = cobi.read()) != -1) {
                charnya= (char) isi;
                stringnya = stringnya + charnya;
            }    

          data = (List<DataUser>) xstream.fromXML(stringnya);
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
        data.add(new DataUser(nama1, uName1, pass1, usia1, gender1));
        String xml = xstream.toXML(data);

        FileOutputStream coba = null;
        try {
        coba = new FileOutputStream("dataUser.xml");
        byte[] bytes = xml.getBytes("UTF-8");
        coba.write(bytes);
        coba.close();
         } catch (Exception e){
               System.err.println("Perhatian: "+e.getMessage());
           }
    
    }
    
//    public  void addDataLogin(String uName1, String pass1){
//        readDataLogin();
//        List<DataUser> data= new ArrayList();
//        XStream xstream = new XStream(new StaxDriver());
//        FileInputStream cobi = null;
//        try {
//            cobi = new FileInputStream("userOnline.xml");
//
//            int isi;
//            char charnya;
//            String stringnya;
//
//            stringnya ="";
//            while ((isi = cobi.read()) != -1) {
//                charnya= (char) isi;
//                stringnya = stringnya + charnya;
//            }    
//
//          data = (List<DataUser>) xstream.fromXML(stringnya);
//        }
//        catch (Exception e){
//            System.err.println("test: "+e.getMessage());
//        }
//        finally{
//          if(cobi == null){
//              try{
//                  cobi.close();
//              }catch (IOException e) {
//                  e.printStackTrace();
//              }
//          }      
//        }
//        data.add(new DataUser(uName1,pass1));
//        String xml = xstream.toXML(data);
//
//        FileOutputStream coba = null;
//        try {
//        coba = new FileOutputStream("userOnline.xml");
//        byte[] bytes = xml.getBytes("UTF-8");
//        coba.write(bytes);
//        coba.close();
//         } catch (Exception e){
//               System.err.println("Perhatian: "+e.getMessage());
//           }
//    
//    }
    
    public List<DataUser> getReadData(){
      List<DataUser> data= new ArrayList();
      XStream xstream = new XStream(new StaxDriver());
      FileInputStream cobi = null;
      try {
          cobi = new FileInputStream("dataUser.xml");
          
          int isi;
          char charnya;
          String stringnya;

          stringnya ="";
          while ((isi = cobi.read()) != -1) {
              charnya= (char) isi;
              stringnya = stringnya + charnya;
          }    
        data = (List<DataUser>) xstream.fromXML(stringnya);      
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
    
//    public List<DataUser> getReadDataLogin(){
//      List<DataUser> data= new ArrayList();
//      XStream xstream = new XStream(new StaxDriver());
//      FileInputStream cobi = null;
//      try {
//          cobi = new FileInputStream("userOnline.xml");
//          
//          int isi;
//          char charnya;
//          String stringnya;
//
//          stringnya ="";
//          while ((isi = cobi.read()) != -1) {
//              charnya= (char) isi;
//              stringnya = stringnya + charnya;
//          }    
//        data = (List<DataUser>) xstream.fromXML(stringnya);      
//      }
//      catch (Exception e){
//          System.err.println("test: "+e.getMessage());
//      }
//      finally{
//        if(cobi == null){
//            try{
//                cobi.close();
//            }catch (IOException e) {
//                e.printStackTrace();
//            }
//        }      
//      }
//        return data;
//    }
}
