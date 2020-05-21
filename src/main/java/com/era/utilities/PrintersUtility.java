/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.utilities;

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
}
