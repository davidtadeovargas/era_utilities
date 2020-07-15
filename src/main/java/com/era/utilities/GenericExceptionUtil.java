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
public class GenericExceptionUtil {
        
    public void generateException(final String stringID) throws Exception {
        
        final Properties props = DialogPropertiesUitlity.getSingleton().getProperties();
        final String errorMessage = props.getProperty(stringID);
        throw new Exception(errorMessage);
    }
}
