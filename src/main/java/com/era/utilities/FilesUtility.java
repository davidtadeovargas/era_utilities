/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.utilities;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author PC
 */
public class FilesUtility {
    
    private final String LOG_FILE = "log.txt";
    
    protected FilesUtility(){        
    }
    
    public boolean fileExists(final String filePath){        
        return new File(filePath).exists();
    }
    
    public boolean logFileExists(){
        return new File(LOG_FILE).exists();
    }
    
    public String getCurrentWorkingDir(){
        return System.getProperty("user.dir");
    }
    
    public boolean deleteLogFile(){
        if(this.logFileExists()){
            new File(LOG_FILE).delete();
            return true;
        }
        else{
            return false;
        }
    }
    
    public void createEmptyLogFile() throws IOException{
        final boolean exists = this.logFileExists();
        if(!exists){
            new File(LOG_FILE).createNewFile();
        }
    }
    
    public boolean resetLogFile() throws IOException{
        if(this.logFileExists()){
            new File(LOG_FILE).delete();
            
            //Create the new one
            createEmptyLogFile();
            
            return true;
        }
        else{
            return false;
        }
    }
    
    public File getLogFile(){
        return new File(LOG_FILE);
    }
    
    public String getLogFilePath(){
        return new File(LOG_FILE).getAbsolutePath();
    }
    
    public void createNewDir(final String pathDir){
        if(!new File(pathDir).exists())
            new File(pathDir).mkdir();
    }
    
    public void createNewFile(final String pathFile) throws Exception {
        if(!new File(pathFile).exists())
            new File(pathFile).createNewFile();
    }
    
    public void deleteFile(final String pathFile) throws Exception {
        if(new File(pathFile).exists()){
            new File(pathFile).delete();
        }
    }
    
    public void writeToExistingFile(final String pathFile, final String text) throws Exception{
        try (FileWriter myWriter = new FileWriter(pathFile)) {
            myWriter.write(text);
        }
    }
    
    public void copyFile(final String pathFile, final String destinationPath) throws Exception {
        org.apache.commons.io.FileUtils.copyFile(new File(pathFile), new File(destinationPath));
    }
    
    public String getFileNameFromPath(final String filePath){
        return new File(filePath).getName();
    }
}
