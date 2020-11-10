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
            printers.add(PrinterDataModel);
        }
        return printers;
    }
    
    public PrinterDataModel getFirstFromAllPrinters(){
        
        final List<PrinterDataModel> printers = new ArrayList<>();
        PrintService[] ser = PrintServiceLookup.lookupPrintServices(null, null);        
        for (PrintService service : ser) 
        {
            final PrinterDataModel PrinterDataModel = new PrinterDataModel();
            PrinterDataModel.setName(service.getName());
            printers.add(PrinterDataModel);
        }
        return printers.size() > 0 ? printers.get(0) : null;
    }
    
    public void changeDefaultPrinter(final String printerName) throws Exception {
        
        final String sCmd = "RUNDLL32 PRINTUI.DLL,PrintUIEntry /y /n \"" + printerName + "\"";
        final Runtime run = Runtime.getRuntime();
        Process pr = run.exec(sCmd);
        pr.waitFor();
    }
    
    public void changeDefaultUserTicketPrinter() throws Exception {
        final String defaultUserTicketPrinter = UtilitiesFactory.getSingleton().getSessionUtility().getUser().getTicketPrinter();
        this.changeDefaultPrinter(defaultUserTicketPrinter);
    }
    
    public void changeDefaultUserInvoicePrinter() throws Exception {
        final String defaultUserInvoicePrinter = UtilitiesFactory.getSingleton().getSessionUtility().getUser().getInvoicePrinter();
        this.changeDefaultPrinter(defaultUserInvoicePrinter);
    }
    
    public boolean userTicketPrinterExists() throws Exception {
        final String defaultUserTicketPrinter = UtilitiesFactory.getSingleton().getSessionUtility().getUser().getTicketPrinter();
        return defaultUserTicketPrinter!=null;
    }
    public boolean userInvoicePrinterExists() throws Exception {
        final String defaultUserInvoicePrinter = UtilitiesFactory.getSingleton().getSessionUtility().getUser().getInvoicePrinter();
        return defaultUserInvoicePrinter!=null;
    }
}
