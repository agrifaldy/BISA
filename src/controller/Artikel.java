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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.StageStyle;
import model.DataPostingan;
import model.DataPostinganList;


public class Artikel implements Initializable {
    
     @FXML
     private Text Text1;
     
     @FXML
     private Text Judul;
     

     @Override
    public void initialize(URL url, ResourceBundle rb) {
    
    Judul.setText("\" 5 Tips Cara Mengembangkan Usaha Kecil Sukses Menjadi Besar \"");
        
    Text1.setText("Cara mengembangkan usaha kecil sukses menjadi besar itu bukan perkara yang mudah. Pasalnya, untuk melakukan hal tersebut, seorang pengusaha haruslah berusaha dengan sangat keras. Bahkan terkadang mereka rela meninggalkan urusan pribadi demi perkembangan bisnis dagang mereka. Ingat, kunci sukses seorang pengusaha adalah kerja keras, cerdas, dan pantang menyerah.\n" +
"\n" +
" Nah, begitu pun dengan pengusaha  yang menjalan bisnis kecil. Mereka pun harus berjuang dan menerapkan kiat-kiat khusus agar usahanya berhasil dan besar.\n" +
"\n" +
"Kiat atau tips tersebut tidak serta merta diterapkan begitu saja. Akan tetapi, harus dipelajari dan dipahami sebelum benar-benar diterapkan. Tujuannya agar sang pengusaha paham dan mengerti tujuan dan fungsi dari kiat  dan tips mengembangkan usaha kecil itu sendiri.\n" +
"\n" +
"Kiat Menjalankan Usaha Kecil\n" +
"\n" +
"Lalu, seperti apakah tips dan kiat-kiat tersebut? nah, berikut ini adalah beberapa kiat dan tips yang harus Anda terapkan jika bisnis kecil Anda ingin besar dan sukses:\n" +
"\n" +
"#1 Strategi Bisnis Memajukan Usaha Kecil\n" +
"\n" +
"Setiap pengusaha pasti membutuhkan strategi bisnis untuk mengembangkan bisnis mereka, begitu pun dengan Anda.\n" +
"Pasalnya, selain mempermudah Anda dalam menjalankan bisnis, strategi ini sendiri berguna untuk memudahkan Anda untuk menentukan anggaran yang harus dikeluarkan, tindakan yang harus dilakukan, dan sebagai acuan dalam pengembangan sebuah usaha.\n" +
"\n" +
"#2 Menghemat Anggaran Operasional, Teknik Pengembangan Usaha \n" +
"Cara seperti ini berguna untuk meminimalisir pengeluaran dana operasional. Jika dana operasional per bulannya bisa ditekan, kenapa tidak?\n" +
"Tips teknik pengembangan usaha kecil ini sendiri tujuan utamanya adalah untuk meminimalisir biaya pengeluaran, terutama pengeluaran biaya operasional yang tidak penting.\n" +
"\n" +
"#3 Ketahui Harga Pasar\n" +
"\n" +
"Untuk mengembangkan usaha yang Anda geluti, Anda harus senantiasa memperhatikan dan mengetahui harga pasar. Pasalnya, dengan cara ini Anda akan tahu berapa harga produk Anda sebenarnya. Disamping itu, cara ini pun berguna untuk menjaga-jaga apabila ada kenaikan harga atau pun penurunan harga dari produk tersebut.\n" +
"\n" +
"#4 Pahami Pesaing Anda, Cara Berbisnis Kecil\n" +
"\n" +
"Mengenali dan memahami pesaing bisnis adalah sebuah perilaku yang wajib dan harus Anda lakukan. Pasalnya, dengan cara seperti ini Anda akan selalu terpacu untuk menciptakan inovasi terbaru.\n" +
"\n" +
"Bukan hanya itu, tips mengembangkan usaha kecil ini juga akan membuat Anda lebih aktif dan berusaha untuk membuat produk yang lebih bagus dan lebih baik dari pesaing Anda.\n" +
"\n" +
"\n" +
"#5 Meskipun Perusahaan Kecil, Lakukan Investasi\n" +
"\n" +
"Jika bisnis Anda sudah besar dan berkembang dengan baik, sebaiknya lakukan investasi untuk mendapatkan keuntungan yang berlipat ganda. Sedangkan cara untuk investasi pun beragam, dari mulai pasar saham, pembuatan perusahaan start up, atau pun terjun ke pasar Forex.\n" +
"Nah, apabila Anda ingin terjun ke pasar forex, untuk memudahkan Anda dalam memantau dan melakukan trading, Anda bisa menggunakan aplikasi metatrader 4.\n" +
"\n" +
"\n" +
"Manfaat Dari Tips Mengembangkan Usaha\n" +
"\n" +
"Manfaat dari tips mengembangkan usaha kecil di atas sebenarnya cukup beragam. Akan tetapi,dari sekian banyak manfaat yang ada, hanya ada beberapa manfaat nyata yang dapat terlihat. Lalu, seperti apa manfaat tersebut?\n" +
"\n" +
"Nah, berikut ada manfaat yang bisa Anda dapatkan jika menggunakan tips mengembangkan bisnis kecil di atas:\n" +
"\n" +
"1	Menjauhkan Anda dari kegagalan dalam berbisnis.\n" +
"\n" +
"2	Meminimalisir kerugian dalam berbisnis.\n" +
"\n" +
"3	Memudahkan Anda dalam memajukan dan mengembangkan bisnis kecil Anda.\n" +
"\n" +
"4	Meningkatkan profit dan keuntungan yang akan didapat.\n" +
"\n" +
"\n" +
"Pada dasarnya, fungsi utama dari kiat-kiat di atas adalah untuk mengembangkan bisnis kecil yang sedang Anda jalani. Adapun berhasil atau pun tidak, itu semua tergantung dari penerapan Anda akan 5 tips mengembangkan usaha kecil agar menjadi besar di atas.\n" +
"\n" +
"Oh ya, untuk lebih meningkatkan profit dan keuntungan, Anda bisa gunakan hasil bisnis Anda untuk berinfestasi di pasar saham atau pun Forex. Nah, untuk memudahkan Anda dalam melakukan investasi disana, Anda bisa menggunakan aplikasi metatrader 4 untuk membantu Anda dalam memantau, menjual, dan membeli valuta asing disana.\n" +
"\n" +
"Dikutip dari : duwitmu.com\n" +
"");
    }
     public void Beranda(ActionEvent event) throws IOException {
        Parent Beranda = FXMLLoader.load(getClass().getResource("/view/Nav.fxml"));
                Scene scene = new Scene(Beranda);
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(scene);
                //window.initModality(Modality.APPLICATION_MODAL);
                //window.initStyle(StageStyle.UNDECORATED);
                window.show();
    }
}