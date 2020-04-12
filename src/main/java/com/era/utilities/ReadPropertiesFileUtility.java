/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.utilities;

import com.era.logger.LoggerUtility;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author PC
 */
public class ReadPropertiesFileUtility {
    
    private InputStream inputStream;
    
    public Properties getPropValues(final String propFileName) throws Exception {
 
        Properties prop = null;
        try {
            
            prop = new Properties();

            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
            prop.load(inputStream);
        }
        finally {
            inputStream.close();
        }
        
        return prop;
    }        
}
