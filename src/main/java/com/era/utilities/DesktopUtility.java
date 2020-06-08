/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.utilities;

import com.era.utilities.exceptions.DesktopEmailNotSupportedException;
import com.era.utilities.exceptions.DesktopNotSupportedException;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;

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
    
    public void openEmailTo(final String emailTo) throws Exception {
        
        if(!isSupported()){
            throw new DesktopNotSupportedException();
        }
        
        if(!isEmailSupported()){
            throw new DesktopEmailNotSupportedException();
        }
        
        final URI mailto = new URI("mailto:" + emailTo + "?subject=");
        getDesktop().mail(mailto);
    }
    
    public void openURL(final String url) throws Exception {
        
        if(!isSupported()){
            throw new DesktopNotSupportedException();
        }
        
        getDesktop().browse(new URI(url));
    }
    
    public Desktop getDesktop(){
        return Desktop.getDesktop();
    }
    
    public boolean isEmailSupported(){
        return Desktop.getDesktop().isSupported(Desktop.Action.MAIL);
    }
    
    public boolean isSupported() throws IOException {
        return Desktop.isDesktopSupported();
    }
}
