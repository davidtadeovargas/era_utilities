/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.utilities;

import com.era.utilities.exceptions.FilenameDontMatchException;
import com.era.utilities.exceptions.InvalidFileExtensionException;
import java.util.ArrayList;
import java.util.List;
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
    private final List<String> validExtensions = new ArrayList<>();
    private String fileNameMatch;
    
    
    
    protected FileChooserUtility(){        
    }

    public void setTitle(String title) {        
        this.title = title;
    }

    public void setFileNameMatch(String fileNameMatch) {
        this.fileNameMatch = fileNameMatch;
    }
    
    public void addValidExtension(final String validExtension){
        this.validExtensions.add(validExtension);
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
    public void showSaveDialog(final JFrame JFrame) throws Exception {
    
        final JFileChooser fc = new JFileChooser  ();
        fc.setDialogTitle(title);
        fc.setAcceptAllFileFilterUsed(acceptAllFileFilterUsed);
        if(fc.showSaveDialog(JFrame)== JFileChooser.APPROVE_OPTION){
            if(IApproveOpption!=null){
                
                final String absolutePath = fc.getCurrentDirectory().getAbsolutePath();
                final String fileName = fc.getSelectedFile().getName();
                
                //If user needs to match file name
                if(fileNameMatch != null){
                    
                    //If dont match
                    if(fileNameMatch.compareTo(fileName)!=0){
                        throw new FilenameDontMatchException();
                    }
                }
                
                //Check the valid extensions of the selected file
                boolean valid = false;
                for(String validExtension:validExtensions){
                    if(fileName.endsWith(validExtension)){
                        valid = true;
                        break;
                    }
                }
                if(!valid){
                    throw new InvalidFileExtensionException();
                }
                
                //Clear the valid extensions
                validExtensions.clear();
                
                //Call back for the user
                IApproveOpption.onApprove(absolutePath, fileName);
            }
        }            
    }

    //Pops up a "Save File" file chooser dialog.
    public void showSaveFolderDialog(final JFrame JFrame){
    
        final JFileChooser fc = new JFileChooser  ();
        fc.setDialogTitle(title);
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fc.setAcceptAllFileFilterUsed(false);
        if(fc.showOpenDialog(JFrame)== JFileChooser.APPROVE_OPTION){
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
