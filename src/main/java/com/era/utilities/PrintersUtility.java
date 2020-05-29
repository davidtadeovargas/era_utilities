/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.utilities;

import com.era.datamodels.PrinterDataModel;
import java.util.ArrayList;
import java.util.List;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;

/**
 *
 * @author PC
 */
public class PrintersUtility {
    
    public String getDefaultPrinter(){
        final PrintService se = PrintServiceLookup.lookupDefaultPrintService();
        final String defaultPrinter = se.getName();
        return defaultPrinter;
    }
    
    public List<PrinterDataModel> getAllPrinters(){
        
        final List<PrinterDataModel> printers = new ArrayList<>();
        PrintService[] ser = PrintServiceLookup.lookupPrintServices(null, null);        
        for (PrintService service : ser) 
        {
            final PrinterDataModel PrinterDataModel = new PrinterDataModel();
            PrinterDataModel.setName(service.getName());            
        }
        return printers;
    }
    
    public void changeDefaultPrinter(final String printerName) throws Exception {
        
        final String sCmd = "RUNDLL32 PRINTUI.DLL,PrintUIEntry /y /n \"" + printerName + "\"";
        final Runtime run = Runtime.getRuntime();
        Process pr = run.exec(sCmd);
        pr.waitFor();
    }
}
