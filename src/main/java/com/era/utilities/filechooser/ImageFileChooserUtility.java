/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.utilities.filechooser;

/**
 *
 * @author PC
 */
public class ImageFileChooserUtility extends FileChooserUtility{
    
    public ImageFileChooserUtility(){
        
        addValidExtension("jpeg");
        addValidExtension("jpg");
        addValidExtension("bmp");
        addValidExtension("gif");
    }
}
