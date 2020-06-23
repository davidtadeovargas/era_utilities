/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.utilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author PC
 */
public class DateTimeUtility {
    
    protected DateTimeUtility(){       
    }
    
    public String getQuickCurrentTimeAndDate(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();  
        return dtf.format(now);
    }
    
    public Calendar getCurrentDateInCalendar(){
        final Date currentTime = new java.util.Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentTime);
        return calendar;
    }
    
    public Date getCurrentDate(){
        final Date currentTime = new java.util.Date();        
        return currentTime;
    }
}
