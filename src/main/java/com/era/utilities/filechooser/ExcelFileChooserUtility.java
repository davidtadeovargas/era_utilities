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
public class ExcelFileChooserUtility extends FileChooserUtility{
    
    public ExcelFileChooserUtility(){
        
        addValidExtension("xlsx");
        addValidExtension("xls");
    }
}