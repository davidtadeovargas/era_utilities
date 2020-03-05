/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.utilities;

import java.awt.Image;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

/**
 *
 * @author PC
 */
public class ImagesUtility extends BaseUtility {
    
    private String appPath;
    
    
    
    public void init(String appPath){
        this.appPath = appPath;
        
        appPath += "\\Imagenes\\Productos";
        
        if(!new File(appPath).exists()){
            new File(appPath).mkdir();
        }
    }
    
    public void saveImageFromUrl(final String productCode, final String fromUrl) throws IOException {
        
        String folderPath = appPath + "\\Imagenes\\Productos\\" + productCode;
        
        if(!new File(folderPath).exists()){
            new File(folderPath).mkdir();
        }
        
        String prodPath = folderPath + "\\image.png";
        
        saveImageToFile(fromUrl,prodPath);
    }
    
    
    private void saveImageToFile(String imageUrl, String destinationFile) throws IOException {
        
        URL url = new URL(imageUrl);
        InputStream is = url.openStream();
        OutputStream os = new FileOutputStream(destinationFile);

        byte[] b = new byte[2048];
        int length;

        while ((length = is.read(b)) != -1) {
                os.write(b, 0, length);
        }

        is.close();
        os.close();
    }
    
    public void saveImage(final String productCode, final String fromPath) throws IOException {
        
        String prodPath = appPath + "\\Imagenes\\Productos\\" + productCode;
        
        if(!new File(prodPath).exists()){
            new File(prodPath).mkdir();
        }
        
        prodPath += "\\image.png";
                
        if(!new File(fromPath).exists()){
            throw new FileNotFoundException();
        }
        
        copyFileUsingStream(new File(fromPath), new File(prodPath));
    }
    
    public void deleteProductImage(final String productCode) throws IOException {
        
        String prodPath = appPath + "\\Imagenes\\Productos\\" + productCode + "\\image.png";
        
        if(!new File(prodPath).exists()){
            throw new FileNotFoundException();
        }
        
        new File(prodPath).delete();                
    }
    
    public boolean productImageExists(final String productCode) throws IOException {
        
        String prodPath = appPath + "\\Imagenes\\Productos\\" + productCode + "\\image.png";
        
        if(new File(prodPath).exists()){
            return true;
        }
        else{
            return false;
        }
    }
    
    private void copyFileUsingStream(File source, File dest) throws IOException {
        
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }
    }
    
    public String getProductImagePath(final String productCode){
        
        final String prodPath = appPath + "\\Imagenes\\Productos\\" + productCode + "\\image.png";
        
        return prodPath;
    }
}
