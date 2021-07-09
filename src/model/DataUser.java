package model;

public class DataUser {
    private String nama;
    private String userName;
    private String password;
    private String usia;
    private String gender;

    public DataUser(String nama, String userName, String password, String usia, String gender) {
        this.nama = nama;
        this.userName = userName;
        this.password = password;
        this.usia = usia;
        this.gender = gender;
    }
    
    public DataUser(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
    
    public DataUser() {}

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getUsia() {
        return usia;
    }

    public void setUsia(String usia) {
        this.usia = usia;
    }
    
    public String getgender() {
        return gender;
    }

    public void setgender(String gender) {
        this.gender = gender;
    } 
}
