/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.utilities;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author PC
 */
public class JFrameUtils {
    
    private static JFrameUtils JFrameUtils;
    
    
    
    
    private JFrameUtils(){        
    }
    
    public static JFrameUtils getInstance(){
        if(JFrameUtils==null){
            JFrameUtils = new JFrameUtils();
        }
        return JFrameUtils;
    }
    
    //Método para establecer el ícono de la aplicación
    public void setIconToWindow(final JFrame jFrame)
    {        
        final String iconDef = "/imgs/logo.png";
        
        //Si el cliente tiene un logo personalizado entonces la imágen será esa
        Image imgIcon;
        if(new File(new java.io.File("").getAbsolutePath() + "\\Logo.jpg").exists())
            imgIcon = Toolkit.getDefaultToolkit().getImage(new java.io.File("").getAbsolutePath() + "\\Logo.jpg");
        //Else el usuario no tiene icono predefinido entonces usar el del sistema
        else
            imgIcon = new ImageIcon(JFrameUtils.class.getResource(iconDef)).getImage();                
        
        //Coloca el icono de la forma dependiendo de si es forma o dialogo
        jFrame.setIconImage(imgIcon);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {       
        throw new CloneNotSupportedException();
    }
}
