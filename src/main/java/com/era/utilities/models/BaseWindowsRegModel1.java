/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.utilities.models;

/**
 *
 * @author PC
 */
public class BaseWindowsRegModel1 {
    
    protected int hkey;    
    protected String key;
    protected String valueName;
    protected String value;

    public int getHkey() {
        return hkey;
    }

    public void setHkey(int hkey) {
        this.hkey = hkey;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValueName() {
        return valueName;
    }

    public void setValueName(String valueName) {
        this.valueName = valueName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }    
}
