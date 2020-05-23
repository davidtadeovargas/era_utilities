/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author PC
 */
public class DesktopUtility {
    
    protected DesktopUtility(){               
    }
    
    public void edit(final String filePath) throws IOException {
        
        if(Desktop.isDesktopSupported()){
            Desktop.getDesktop().edit(new File(filePath));
        }
    }
    
    public void open(final String path) throws IOException {
        Desktop.getDesktop().open(new File(path));
    }
    
    public boolean isSupported() throws IOException {
        return Desktop.isDesktopSupported();
    }
}
