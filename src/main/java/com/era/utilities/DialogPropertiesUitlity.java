/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.utilities;

import java.util.Properties;

/**
 *
 * @author PC
 */
public class DialogPropertiesUitlity {
    
    static private DialogPropertiesUitlity DialogPropertiesUitlity;
    
    private Properties Properties;
    
    
    protected DialogPropertiesUitlity(){        
    }
    
    public static DialogPropertiesUitlity getSingleton(){
        if(DialogPropertiesUitlity==null){
            DialogPropertiesUitlity = new DialogPropertiesUitlity();
        }
        return DialogPropertiesUitlity;
    }
    
    public Properties getProperties() throws Exception {
        
        if(Properties==null){
            final ReadPropertiesFileUtility ReadPropertiesFileUtility = new ReadPropertiesFileUtility();
            Properties = ReadPropertiesFileUtility.getPropValues("properties/dialogs.properties");
        }
        
        return Properties;
    }
    
    public String getString(final String property) throws Exception {
        
        final Properties Properties = this.getProperties();
        final String cadena = Properties.getProperty(property);
        
        return cadena;
    }
}
