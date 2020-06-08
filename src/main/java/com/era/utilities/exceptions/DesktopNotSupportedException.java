/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.utilities.exceptions;

/**
 *
 * @author PC
 */
public class DesktopNotSupportedException extends Exception {
    
    public DesktopNotSupportedException(){
        super("errors_functionality_not_supported");
    }
}
