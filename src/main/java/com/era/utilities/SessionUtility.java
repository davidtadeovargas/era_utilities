/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.utilities;

import com.era.models.BasDats;
import com.era.models.User;
import com.era.repositories.RepositoryFactory;

/**
 *
 * @author PC
 */
public class SessionUtility {
    
    private BasDats BasDats;
    private User User = new User();    
    private String userLoggedTime;
    
    
    protected SessionUtility(){
    }

    public BasDats getBasDats() {
        return BasDats;
    }

    public void setBasDats(BasDats BasDats) {
        this.BasDats = BasDats;
    }

    public User getUser() {
        return User;
    }

    public String getUserLoggedTime() {
        return userLoggedTime;
    }
        
    public void userInitSession(final User User) throws Exception{
        
        //Save the current session
        this.User = User;
        final String currentTimeAndDate = UtilitiesFactory.getSingleton().getDateTimeUtility().getQuickCurrentTimeAndDate();            
        this.userLoggedTime = currentTimeAndDate;
        
        //Log the loggin of the user
        RepositoryFactory.getInstance().getUsersRepository().userLoggedToSystem(this.User.getStation());
    }
    
    public void deslogUserSession() throws Exception{
        
        //Save the current session        
        final String currentTimeAndDate = UtilitiesFactory.getSingleton().getDateTimeUtility().getQuickCurrentTimeAndDate();            
        this.userLoggedTime = currentTimeAndDate;
        
        //Log the loggin of the user
        RepositoryFactory.getInstance().getUsersRepository().userDeloggedToSystem(this.User.getStation());
    }
}
