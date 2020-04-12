/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.utilities;

import java.util.Date;

/**
 *
 * @author PC
 */
public class GeneralsUtility {
    
    private static GeneralsUtility GeneralsUtility;
    
    
    public static GeneralsUtility getSingleton(){
        if(GeneralsUtility==null){
            GeneralsUtility = new GeneralsUtility();
        }
        return GeneralsUtility;
    }
    
    public String getUniqueDayCode(){
        
        String sClav   = "";
        
        Date dat = new Date();
        
        sClav = sClav + Integer.toString(dat.getDate());
        sClav = sClav + Integer.toString(dat.getMonth());
        sClav = sClav + Integer.toString(dat.getYear());
        sClav = sClav + Integer.toString(dat.getHours());
        sClav = sClav + Integer.toString(dat.getMinutes());
        sClav = sClav + Integer.toString(dat.getSeconds());
                
        return sClav;        
    }
}
