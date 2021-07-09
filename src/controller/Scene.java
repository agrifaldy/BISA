/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

/**
 *
 * @author ASUS
 */
public class Scene {
    private Pane halaman;
    
    public Pane getPane(String fileName){
        try{
            URL fileHalaman = Nav.class.getResource("/view/"+fileName+".fxml");
            
            if(fileHalaman == null){
                throw new java.io.FileNotFoundException("Halaman tidak ada");
            }
            
            halaman = new FXMLLoader().load(fileHalaman);
        } catch(Exception e){
            System.out.println("Tidak ada");
        }
        
        return halaman;
    }
}
