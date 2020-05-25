/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.utilities;

import com.era.logger.LoggerUtility;
import com.era.utilities.models.ConfigFileModel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
        
/**
 *
 * @author PC
 */
public class ConfigFileUtil {
    
    private static ConfigFileUtil ConfigFileUtil;
    private final String pathFileConf = com.era.Constants.CONFIG_FILE;
    private ConfigFileModel ConfigFileModel;
    
    protected ConfigFileUtil(){        
    }

    final public static ConfigFileUtil getSingleton(){
        if(ConfigFileUtil==null){
            ConfigFileUtil = new ConfigFileUtil();
        }
        return ConfigFileUtil;
    }
    
    public ConfigFileModel getConfigFileModel() throws Exception {
        
        if(ConfigFileModel == null){
            
            //Read the file from disk        
            try(FileInputStream fileIn = new FileInputStream(pathFileConf); 
                ObjectInputStream in = new ObjectInputStream(fileIn)){
               ConfigFileModel = (ConfigFileModel)in.readObject();
            }

            //Dencrypt the data
            LoggerUtility.getSingleton().logInfo(ConfigFileUtil.class, "Decrypting getInstance: " + ConfigFileModel.getInstance());        
            ConfigFileModel.setInstance(UtilitiesFactory.getSingleton().getSecurityUtil().decryptString(ConfigFileModel.getInstance()));
            LoggerUtility.getSingleton().logInfo(ConfigFileUtil.class, "Decrypting getUser: " + ConfigFileModel.getInstance());
            ConfigFileModel.setUser(UtilitiesFactory.getSingleton().getSecurityUtil().decryptString(ConfigFileModel.getUser()));
            LoggerUtility.getSingleton().logInfo(ConfigFileUtil.class, "Decrypting getPassword: " + ConfigFileModel.getInstance());
            ConfigFileModel.setPassword(UtilitiesFactory.getSingleton().getSecurityUtil().decryptString(ConfigFileModel.getPassword()));
            LoggerUtility.getSingleton().logInfo(ConfigFileUtil.class, "Decrypting getDb: " + ConfigFileModel.getInstance());
            ConfigFileModel.setDb(UtilitiesFactory.getSingleton().getSecurityUtil().decryptString(ConfigFileModel.getDb()));
            LoggerUtility.getSingleton().logInfo(ConfigFileUtil.class, "Decrypting getCashNumber: " + ConfigFileModel.getInstance());
            ConfigFileModel.setCashNumber(UtilitiesFactory.getSingleton().getSecurityUtil().decryptString(ConfigFileModel.getCashNumber()));
            LoggerUtility.getSingleton().logInfo(ConfigFileUtil.class, "Decrypting getPort: " + ConfigFileModel.getInstance());
            ConfigFileModel.setPort(UtilitiesFactory.getSingleton().getSecurityUtil().decryptString(ConfigFileModel.getPort()));
            LoggerUtility.getSingleton().logInfo(ConfigFileUtil.class, "Decrypting getCompanyName: " + ConfigFileModel.getInstance());
            ConfigFileModel.setCompanyName(UtilitiesFactory.getSingleton().getSecurityUtil().decryptString(ConfigFileModel.getCompanyName()));
        }
                
        return ConfigFileModel;
    }
    
    public void createConfigFile(ConfigFileModel ConfigFileModel) throws Exception {
        
        //Encrypt the data
        LoggerUtility.getSingleton().logInfo(ConfigFileUtil.class, "Encripting getInstance: " + ConfigFileModel.getInstance());        
        ConfigFileModel.setInstance(UtilitiesFactory.getSingleton().getSecurityUtil().encryptString(ConfigFileModel.getInstance()));
        LoggerUtility.getSingleton().logInfo(ConfigFileUtil.class, "Encripting getUser: " + ConfigFileModel.getInstance());
        ConfigFileModel.setUser(UtilitiesFactory.getSingleton().getSecurityUtil().encryptString(ConfigFileModel.getUser()));
        LoggerUtility.getSingleton().logInfo(ConfigFileUtil.class, "Encripting getPassword: " + ConfigFileModel.getInstance());
        ConfigFileModel.setPassword(UtilitiesFactory.getSingleton().getSecurityUtil().encryptString(ConfigFileModel.getPassword()));
        LoggerUtility.getSingleton().logInfo(ConfigFileUtil.class, "Encripting getDb: " + ConfigFileModel.getInstance());
        ConfigFileModel.setDb(UtilitiesFactory.getSingleton().getSecurityUtil().encryptString(ConfigFileModel.getDb()));
        LoggerUtility.getSingleton().logInfo(ConfigFileUtil.class, "Encripting getCashNumber: " + ConfigFileModel.getInstance());
        ConfigFileModel.setCashNumber(UtilitiesFactory.getSingleton().getSecurityUtil().encryptString(ConfigFileModel.getCashNumber()));        
        LoggerUtility.getSingleton().logInfo(ConfigFileUtil.class, "Encripting getCashNumber: " + ConfigFileModel.getSucursal());
        ConfigFileModel.setSucursal(UtilitiesFactory.getSingleton().getSecurityUtil().encryptString(ConfigFileModel.getSucursal()));
        LoggerUtility.getSingleton().logInfo(ConfigFileUtil.class, "Encripting getPort: " + ConfigFileModel.getInstance());
        ConfigFileModel.setPort(UtilitiesFactory.getSingleton().getSecurityUtil().encryptString(ConfigFileModel.getPort()));
        LoggerUtility.getSingleton().logInfo(ConfigFileUtil.class, "Encripting getCompanyName: " + ConfigFileModel.getInstance());
        ConfigFileModel.setCompanyName(UtilitiesFactory.getSingleton().getSecurityUtil().encryptString(ConfigFileModel.getCompanyName()));
        
        //Serialize the model to disk
        try (FileOutputStream fi = new FileOutputStream(pathFileConf)) {
            ObjectOutputStream out = new ObjectOutputStream(fi);
            out.writeObject(ConfigFileModel);            
        }
    }
    
    public boolean configFileExists(){
        return new File(pathFileConf).exists();
    }
    
    public String getConfigFilePath(){
        if(this.configFileExists()){
            return new File(pathFileConf).getAbsolutePath();
        }
        else{
            return null;
        }
    }
    
    public void deleteFile(){
        new File(pathFileConf).delete();
    }
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }
}
