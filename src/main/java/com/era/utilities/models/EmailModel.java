/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.utilities.models;

/**
 *
 * @author PC
 */
public class EmailModel{
        
        private String smtpSal;
        private int smtpPort;
        private boolean useSSL;
        private String username;
        private String password;

        public String getSmtpSal() {
            return smtpSal;
        }

        public void setSmtpSal(String smtpSal) {
            this.smtpSal = smtpSal;
        }

        public int getSmtpPort() {
            return smtpPort;
        }

        public void setSmtpPort(int smtpPort) {
            this.smtpPort = smtpPort;
        }

        public boolean isUseSSL() {
            return useSSL;
        }

        public void setUseSSL(boolean useSSL) {
            this.useSSL = useSSL;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
        
        
        
    }