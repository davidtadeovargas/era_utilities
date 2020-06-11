/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.utilities;

import com.era.utilities.exceptions.InvalidFileExtensionException;
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
    
    
    
    protected ImagesUtility(){
    }
    
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
    
    public void openImageInVisor(final String imagePath) throws IOException {
        UtilitiesFactory.getSingleton().getDesktopUtility().open(imagePath);        
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
    
    public String getFTecnicalProductPath(final String productCode) throws Exception {
        
        final String path = appPath + "\\FTecnica\\" + productCode;
        
        //Get the path to the technical file
        final String pathToFile = UtilitiesFactory.getSingleton().getFilesUtility().getFirstFilePathFromPath(path);
        
        //Return the path
        return pathToFile;
    }
    public void saveFTecnicaProduct(final String productCode, final String fromPath) throws Exception {
        
        String prodPath = appPath + "\\FTecnica\\" + productCode;
        
        if(!new File(prodPath).exists()){
            new File(prodPath).mkdir();
        }
                
        if(fromPath.endsWith(".pdf")){
            prodPath += "\\ftecnica.pdf";
        }
        else if(fromPath.endsWith(".docx")){
            prodPath += "\\ftecnica.docx";
        }
        else{
            throw new InvalidFileExtensionException();
        }
                
        if(!new File(fromPath).exists()){
            throw new FileNotFoundException();
        }
        
        copyFileUsingStream(new File(fromPath), new File(prodPath));
    }
    public void deleteFTechnicalProduct(final String productCode) throws Exception {
        
        //Path to the technical product file folder
        final String path = appPath + "\\FTecnica\\" + productCode;
        
        //Get the path to the technical file
        final String pathToFile = UtilitiesFactory.getSingleton().getFilesUtility().getFirstFilePathFromPath(path);
        
        if(!new File(pathToFile).exists()){
            throw new FileNotFoundException();
        }
        
        new File(pathToFile).delete();                
    }
    public boolean FTechnicalProductExists(final String productCode) throws Exception {
        
        final String path = appPath + "\\FTecnica\\" + productCode;
        
        //Get the path to the technical file
        final String pathToFile = UtilitiesFactory.getSingleton().getFilesUtility().getFirstFilePathFromPath(path);
        
        return new File(pathToFile).exists();
    }
    
    public void saveProductImage(final String productCode, final String fromPath) throws IOException {
        
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
    public String getProductImagePath(final String productCode){
        
        final String prodPath = appPath + "\\Imagenes\\Productos\\" + productCode + "\\image.png";
        return prodPath;
    }
    
    public void saveUserImage(final String user, final String fromPath) throws IOException {
        
        //Users path should exist
        String userPath = appPath + "\\Imagenes\\Usuarios";        
        if(!new File(userPath).exists()){
            new File(userPath).mkdir();
        }
        
        //Users specific code path should exist
        String userCodePath = userPath + "\\" + user;
        if(!new File(userCodePath).exists()){
            new File(userCodePath).mkdir();
        }
        
        //Complete final path
        userCodePath += "\\image.png";
                
        //The source image should exist
        if(!new File(fromPath).exists()){
            throw new FileNotFoundException();
        }
        
        //Save the image
        copyFileUsingStream(new File(fromPath), new File(userCodePath));
    }
    public void deleteUserImage(final String user) throws IOException {
        
        String userPath = appPath + "\\Imagenes\\Usuarios\\" + user + "\\image.png";
        
        if(!new File(userPath).exists()){
            throw new FileNotFoundException();
        }
        
        new File(userPath).delete();                
    }
    public boolean usersImageExists(final String user) throws IOException {
        
        String userPath = appPath + "\\Imagenes\\Usuarios\\" + user + "\\image.png";
        
        if(new File(userPath).exists()){
            return true;
        }
        else{
            return false;
        }
    }
    public String getUserImagePath(final String user){
        
        final String userPath = appPath + "\\Imagenes\\Usuarios\\" + user + "\\image.png";        
        return userPath;
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
}
