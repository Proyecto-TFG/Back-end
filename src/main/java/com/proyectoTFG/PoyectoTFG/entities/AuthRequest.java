package com.proyectoTFG.PoyectoTFG.entities;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public class AuthRequest {

    @NotNull @Email @Length(min = 5,max = 50)
    private String email;

    @NotNull @Length(min = 5,max = 10)
    private String password;


    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

     
    
}
