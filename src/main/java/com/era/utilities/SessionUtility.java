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
public class SessionUtility {
    
    private BasDats BasDats;
    private User User;
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

    public void setUser(User User) {
        this.User = User;
    }

    public String getUserLoggedTime() {
        return userLoggedTime;
    }

    public void setUserLoggedTime(String userLoggedTime) {
        this.userLoggedTime = userLoggedTime;
    }
}
