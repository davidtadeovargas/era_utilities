/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.utilities;

import javax.swing.ImageIcon;

/**
 *
 * @author PC
 */
public class IconsUtility {
    
    protected IconsUtility(){        
    }
    
    public ImageIcon getImageIconFromImage(final String image){
        
        ImageIcon img = new ImageIcon(new ImageIcon(getClass().getResource("/imgs/" + image)).getImage());
        java.awt.Image im = img.getImage(); 
        java.awt.Image newimg = im.getScaledInstance( 600, 350,  java.awt.Image.SCALE_SMOOTH );
        img = new ImageIcon(newimg);
        return img;
    }
}
