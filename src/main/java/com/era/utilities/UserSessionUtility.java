/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.utilities;

/**
 *
 * @author PC
 */
public class UserSessionUtility {
    
    private String user;
    private String estation;
    private String sucursal;

    
    
    
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getEstation() {
        return estation;
    }

    public void setEstation(String estation) {
        this.estation = estation;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }
    
    public void setUserInSession(final String user, final String estation, final String sucursal){
        this.user = user;
        this.estation = estation;
        this.sucursal = sucursal;
    }
}
