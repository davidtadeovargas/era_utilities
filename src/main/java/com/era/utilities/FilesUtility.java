/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.utilities;

import java.io.File;

/**
 *
 * @author PC
 */
public class FilesUtility {
    
    protected FilesUtility(){        
    }
    
    public boolean fileExists(final String filePath){        
        return new File(filePath).exists();
    }
    
    public void createNewDir(final String pathDir){
        if(!new File(pathDir).exists())
            new File(pathDir).mkdir();
    }
    
    public void copyFile(final String pathFile, final String destinationPath) throws Exception {
        org.apache.commons.io.FileUtils.copyFile(new File(pathFile), new File(destinationPath));
    }
    
    public String getFileNameFromPath(final String filePath){
        return new File(filePath).getName();
    }
}
