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
import java.util.regex.Pattern;

/**
 *
 * @author PC
 */
public class NumbersUtility extends BaseUtility {

    private final String[] UNIDADES = {"", "un ", "dos ", "tres ", "cuatro ", "cinco ", "seis ", "siete ", "ocho ", "nueve "};
    private final String[] DECENAS = {"diez ", "once ", "doce ", "trece ", "catorce ", "quince ", "dieciseis ",
        "diecisiete ", "dieciocho ", "diecinueve", "veinte ", "treinta ", "cuarenta ",
        "cincuenta ", "sesenta ", "setenta ", "ochenta ", "noventa "};
    private final String[] CENTENAS = {"", "ciento ", "doscientos ", "trecientos ", "cuatrocientos ", "quinientos ", "seiscientos ",
        "setecientos ", "ochocientos ", "novecientos "};
    
    public String toMoneyFormat(final BigDecimal value) throws Exception {
        return toMoneyFormat(String.valueOf(value));
    }
    
    public String convertNumberToStringRepresentation(String numero, final String simbol, final String coinCode, final boolean monedaNacional, final boolean mayusculas) {
        
        String terminacion = "";
        if(monedaNacional){
            terminacion = "M.N.";
        }

        BigDecimal num = new BigDecimal(numero.replace("$","").replace(",",""));
        numero = num.setScale(2,BigDecimal.ROUND_HALF_EVEN).toString();
        
        String literal;
        String parte_decimal;    
        //si el numero utiliza (.) en lugar de (,) -> se reemplaza
        numero = numero.replace(".", ",");
        //si el numero no tiene parte decimal, se le agrega ,00
        if(numero.indexOf(",")==-1){
            numero = numero + ",00";
        }
        //se valida formato de entrada -> 0,00 y 999 999 999,00
        if(Pattern.matches("\\d{1,9},\\d{1,6}", numero)) {
            //se divide el numero 0000000,00 -> entero y decimal
            String Num[] = numero.split(",");            
            //de da formato al numero decimal
            parte_decimal = coinCode + " ." + Num[1] + "/100 " + terminacion;
            //se convierte el numero a literal
            if(Integer.parseInt(Num[0]) == 0) {//si el valor es cero
                literal = "cero ";
            } else if(Integer.parseInt(Num[0]) > 999999) {//si es millon
                literal = getMill(Num[0]);
            } else if(Integer.parseInt(Num[0]) > 999) {//si es miles
                literal = getMil(Num[0]);
            } else if(Integer.parseInt(Num[0]) > 99) {//si es centena
                literal = getCent(Num[0]);
            } else if(Integer.parseInt(Num[0]) > 9) {//si es decena
                literal = getDec(Num[0]);
            } else {//sino unids -> 9
                literal = getUnid(Num[0]);
            }
            //devuelve el resultado en mayusculas o minusculas
            if(mayusculas) {
                return (literal + parte_decimal).toUpperCase();
            } else {
                return (literal + parte_decimal);
            }
        } 
        else {//error, no se puede convertir
            return literal = null;
        }
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
    
    public BigDecimal fromMoneyFormatToBigDecimal(final String value) throws Exception {
        
        //Get the text
        String text = value.replace(",", "").replace("$", "");
        
        if(text.isEmpty()){
            text = "0";
        }                

        //Return the value
        return new BigDecimal(text);
    }
    
    /*Obtiene los millones*/
    private String getMill(String numero) 
    { 
        //se obtiene los miles
        String miles = numero.substring(numero.length() - 6);
        //se obtiene los millones
        String millon = numero.substring(0, numero.length() - 6);
        String n;
        if(millon.length()>1){
            n = getCent(millon) + "millones ";
        }else{
            n = getUnid(millon) + "millon ";
        }
        return n + getMil(miles);        
    }
    
    
    /*Obtiene las decenas*/
    private String getDec(String num) 
    {                        
        int n = Integer.parseInt(num);
        if(n < 10) 
        {
            return getUnid(num);
        } 
        else if(n > 19) 
        {
            String u = getUnid(num);
            if(u.equals("")) { //para 20,30,40,50,60,70,80,90
                return DECENAS[Integer.parseInt(num.substring(0, 1)) + 8];
            } else {
                return DECENAS[Integer.parseInt(num.substring(0, 1)) + 8] + "y " + u;
            }
        } 
        else 
        {
            return DECENAS[n - 10];
        }
        
    }/*Fin de private String getDec(String num) */
        
    /*Obtiene las centenas*/
    private String getCent(String num) 
    {
        if( Integer.parseInt(num)>99 )
        {
            if(Integer.parseInt(num) == 100) {//caso especial
                return " cien ";
            } else {
                 return CENTENAS[Integer.parseInt(num.substring(0, 1))] + getDec(num.substring(1));
            } 
        }
        else
        {
            //se quita el 0 antes de convertir a decenas
            return getDec(Integer.parseInt(num)+"");            
        }                
    }
    
    private String getMil(String numero) 
    {
        //obtiene las centenas
        String c = numero.substring(numero.length() - 3);
        //obtiene los miles
        String m = numero.substring(0, numero.length() - 3);
        String n="";
        //se comprueba que miles tenga valor entero
        if(Integer.parseInt(m) > 0) {
            n = getCent(m);           
            return n + "mil " + getCent(c);
        } else {
            return "" + getCent(c);
        } 
    }
    
    private String getUnid(String numero) 
    {
        //si tuviera algun 0 antes se lo quita -> 09 = 9 o 009=9
        String num = numero.substring(numero.length() - 1);
        return UNIDADES[Integer.parseInt(num)];
    }
}
