/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.utilities.models;

import com.era.utilities.WinRegistry;

/**
 *
 * @author PC
 */
public class LicenseWindowsRegModel extends BaseWindowsRegModel {
    
    public LicenseWindowsRegModel(final String serial){
        
        super();
        
        //Define he hkey
        hkey = WinRegistry.HKEY_CURRENT_USER;        
        
        //Define the key
        key = "ERA";
        
        //Define the value name
        valueName = "serial";

        //Define the value 
        value = serial;
    }
}
