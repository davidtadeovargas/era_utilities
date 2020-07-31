/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.utilities;

import com.era.utilities.exceptions.EmptyStringException;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author PC
 */
public class NumbersUtility extends BaseUtility {
    
    public String toMoneyFormat(final BigDecimal value) throws Exception {
        return toMoneyFormat(String.valueOf(value));
    }
    
    public String toMoneyFormat(final float value) throws Exception {
        return toMoneyFormat(String.valueOf(value));
    }
        
    public String toMoneyFormat(final String value) throws Exception {
        
        //Get the text
        String text = value.replace(",", "").replace("$", "");

        //If empty just return
        if(text.isEmpty()){
            throw new EmptyStringException();
        }

        //Try to parse to double to check is a valid number
        double d = Double.parseDouble(text);        

        //Money format
        double dCant = Double.parseDouble(text);
        NumberFormat n = NumberFormat.getCurrencyInstance(new Locale("es","MX"));
        text = n.format(dCant);

        //Return the value
        return text;
    }
    
    public String fromMoneyFormat(final String value) throws Exception {
        
        //Get the text
        String text = value.replace(",", "").replace("$", "");
        
        if(text.isEmpty()){
            text = "0";
        }                

        //Return the value
        return text;
    }
}
