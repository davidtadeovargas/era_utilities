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
public class UtilityManager {

    private static UtilityManager UtilityManager;
    private ImagesUtility ImagesUtility;
    private SecurityUtil SecurityUtil;
    
    
    private UtilityManager(){
    }
   
    public static UtilityManager getSingleton(){
        if(UtilityManager==null){
            UtilityManager = new UtilityManager();
        }
        return UtilityManager;
    }

    public ImagesUtility getImagesUtility(){
        if(ImagesUtility==null){
            ImagesUtility = new ImagesUtility();
        }
        return ImagesUtility;
    }
    
    public SecurityUtil getSecurityUtil(){
        if(SecurityUtil==null){
            SecurityUtil = new SecurityUtil();
        }
        return SecurityUtil;
    }
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }
}
