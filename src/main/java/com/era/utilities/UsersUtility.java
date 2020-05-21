/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.utilities;

import com.era.models.BasDats;
import com.era.models.User;

/**
 *
 * @author PC
 */
public class UsersUtility {
    
    public String getSessionString(){
        
        final BasDats BasDats = UtilitiesFactory.getSingleton().getSessionUtility().getBasDats();
        final User User = UtilitiesFactory.getSingleton().getSessionUtility().getUser();
        final String userLoggedTime = UtilitiesFactory.getSingleton().getSessionUtility().getUserLoggedTime();
        
        final String basdatsNom = BasDats == null ? "": BasDats.getNom();
        
        final String text = basdatsNom + " Usuario: <" + User.getName() + "> V2.5.9 " + userLoggedTime;
        return text;
    }
}
