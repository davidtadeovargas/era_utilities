/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.utilities;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author PC
 */
public class ConnectivityUtil extends BaseUtility {
    
    final public boolean isInternetConnection(){
        
        boolean internet = true;
        try {
         URL url = new URL("http://www.google.com");
         URLConnection connection = url.openConnection();
         connection.connect();
         System.out.println("Internet is connected");
      } catch (MalformedURLException e) {
         internet = false;
      } catch (IOException e) {
         internet = false;
      }
        
        return internet;
    }
}
