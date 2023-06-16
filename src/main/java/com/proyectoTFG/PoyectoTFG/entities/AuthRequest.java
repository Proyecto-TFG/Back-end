package com.proyectoTFG.PoyectoTFG.entities;

public class AuthRequest {

    private String userName;
    private String password;

    public AuthRequest() {
    }

    public AuthRequest(String userName, String password) {
        this.setUserName(userName);
        this.setPassword(password);
    }


    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
}
