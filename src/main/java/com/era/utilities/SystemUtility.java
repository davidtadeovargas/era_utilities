/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.utilities;

import com.era.easyretail.Start;
import com.era.logger.LoggerUtility;
import java.io.File;
import java.io.FileNotFoundException;

/**
 *
 * @author PC
 */
public class SystemUtility {
    
    protected SystemUtility(){        
    }
    
    public void restartSystem() throws Exception {
        
        LoggerUtility.getSingleton().logInfo(SystemUtility.class, "Entered to restartSystem()");
        
        StringBuilder cmd = new StringBuilder();
        final String workingDir = System.getProperty("user.dir");
        final String pathToJar = com.era.Constants.PATH_TO_JAR;
        final String jarName = com.era.Constants.JAR_NAME;
        final String finalPath = workingDir + "\\" + pathToJar + "\\" + jarName;
        final String command = "java -jar \"" + finalPath + "\"";
        cmd.append(command);
        LoggerUtility.getSingleton().logInfo(SystemUtility.class, "Running command: " + command);        
        
        //Execute command
        Runtime.getRuntime().exec(cmd.toString());

        //Exit system
        System.exit(0);
    }
}
