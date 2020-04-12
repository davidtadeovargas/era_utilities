/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.utilities;

import java.util.Properties;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

/**
 *
 * @author PC
 */
public class FileChooserUtility {
    
    private String title;
    private boolean acceptAllFileFilterUsed;
    private IApproveOpption IApproveOpption;
    
    
    
    protected FileChooserUtility(){        
    }

    public void setTitle(String title) {        
        this.title = title;
    }
    
    public void setPropertyTitle(String title) throws Exception {
        final Properties props = UtilitiesFactory.getSingleton().getDialogPropertiesUitlity().getProperties();
        final String title_ = props.getProperty(title);        
        this.title = title_;
    }

    public void setAcceptAllFileFilterUsed(boolean acceptAllFileFilterUsed) {
        this.acceptAllFileFilterUsed = acceptAllFileFilterUsed;
    }
    
    //Pops up a "Save File" file chooser dialog.
    public void showSaveDialog(final JFrame JFrame){
    
        final JFileChooser fc = new JFileChooser  ();
        fc.setDialogTitle(title);
        fc.setAcceptAllFileFilterUsed(acceptAllFileFilterUsed);
        if(fc.showSaveDialog(JFrame)== JFileChooser.APPROVE_OPTION){
            if(IApproveOpption!=null){
                final String absolutePath = fc.getCurrentDirectory().getAbsolutePath();
                final String fileName = fc.getSelectedFile().getName();
                IApproveOpption.onApprove(absolutePath, fileName);
            }
        }            
    }

    public void setIApproveOpption(IApproveOpption IApproveOpption) {
        this.IApproveOpption = IApproveOpption;
    }
    
    
    public interface IApproveOpption{
        public void onApprove(String absolutePath, String fileName);
    }
}
