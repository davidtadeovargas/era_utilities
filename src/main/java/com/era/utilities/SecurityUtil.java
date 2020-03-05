/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.utilities;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 *
 * @author PC
 */
public class SecurityUtil extends BaseUtility {
    
    private byte[] sClavEncrip = new byte[]{'a','5','z','8','y','1','I','S','N','C','O','N','S','U','L','T'};
    
    private static SecurityUtil SecurityUtil;
    
    protected SecurityUtil(){        
    }
    
    
    
    
    public String encryptString(String toEncript) throws Exception {
        
        //Encript the data
        Key key         = new SecretKeySpec(sClavEncrip, "AES");
        Cipher c        = Cipher.getInstance("AES");
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encVal   = c.doFinal(toEncript.getBytes());        
        final String encrypVal = new BASE64Encoder().encode(encVal);           
        
        //Return the result
        return encrypVal;
    }
    
    public String decryptString(String encripted) throws Exception {
        
        
        Key key = new SecretKeySpec(sClavEncrip, "AES");
        Cipher c = Cipher.getInstance("AES");
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] decordedValue = new BASE64Decoder().decodeBuffer(encripted);
        byte[] decValue = c.doFinal(decordedValue);
        final String dencrypVal = new String(decValue);
        
        /*Devuelve el resultado*/
        return dencrypVal;
    }
}
