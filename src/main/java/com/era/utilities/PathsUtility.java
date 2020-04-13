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
public class PathsUtility {
    
    private String appPath = ".";
    private String imagesPath;
    private String logoPath;
    private String companyLogoPath;
    private final String logoFileName = "Logo.jpg";
    
    
    
    protected PathsUtility(){        
    }

    public void initPaths(String appPath,final String companyCode) {
        
        if(appPath!=null){
            this.appPath = appPath;
        }
        
        this.imagesPath = this.appPath + "\\Imagenes";
        this.logoPath = this.appPath + "\\Logotipo Empresa";
        this.companyLogoPath = this.logoPath + "\\" + companyCode;
        
        if(!UtilitiesFactory.getSingleton().getFilesUtility().fileExists(imagesPath)){
            UtilitiesFactory.getSingleton().getFilesUtility().createNewDir(imagesPath);
        }
        
        if(!UtilitiesFactory.getSingleton().getFilesUtility().fileExists(logoPath)){
            UtilitiesFactory.getSingleton().getFilesUtility().createNewDir(logoPath);
        }
        
        if(!companyCode.isEmpty()){
            if(!UtilitiesFactory.getSingleton().getFilesUtility().fileExists(companyLogoPath)){
                UtilitiesFactory.getSingleton().getFilesUtility().createNewDir(companyLogoPath);
            }
        }
    }   

    public String getAppPath() {
        return appPath;
    }

    public String getImagesPath() {
        return imagesPath;
    }

    public String getLogoPath() {
        return logoPath;
    }

    public String getCompanyLogoPath() {
        return companyLogoPath;
    }

    public String getLogoFileName() {
        return logoFileName;
    }
}
