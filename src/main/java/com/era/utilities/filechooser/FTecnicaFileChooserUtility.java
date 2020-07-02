/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.utilities.filechooser;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author PC
 */
public class FTecnicaFileChooserUtility extends FileChooserUtility{
    
    public FTecnicaFileChooserUtility(){
        
        addValidExtension("pdf");
        FileFilter FileFilter = new FileFilter() {
            @Override
            public boolean accept(File f) {
                if (f.isDirectory()) {
                    return true;
                } else {
                    return f.getName().toLowerCase().endsWith(".pdf");
                }
            }
            @Override
            public String getDescription() {
                return "pdf (*.pdf)";
            }
        };
        FileFilters.add(FileFilter);
        
        addValidExtension("docx");
        FileFilter = new FileFilter() {
            @Override
            public boolean accept(File f) {
                if (f.isDirectory()) {
                    return true;
                } else {
                    return f.getName().toLowerCase().endsWith(".docx");
                }
            }
            @Override
            public String getDescription() {
                return "docx (*.docx)";
            }
        };
        FileFilters.add(FileFilter);
    }
}
