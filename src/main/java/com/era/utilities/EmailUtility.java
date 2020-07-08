/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.utilities;

import com.era.logger.LoggerUtility;
import com.era.utilities.models.EmailModel;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.internet.MimeMessage;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;

/**
 *
 * @author PC
 */
public class EmailUtility {
    
    protected EmailUtility(){        
    }
    
    public void sendTest(final EmailModel EmailModel) throws Exception {
        this.send(EmailModel, null, Type.TEST);
    }
    
    public void send(final EmailModel EmailModel, Message Message,final Type Type_) throws Exception {
        
        LoggerUtility.getSingleton().logInfo(getClass(), "Sending email with the next connection params: ");
        LoggerUtility.getSingleton().logInfo(getClass(), "smtp server: " + EmailModel.getSmtpSal());
        LoggerUtility.getSingleton().logInfo(getClass(), "smtp port: " + EmailModel.getSmtpPort());
        LoggerUtility.getSingleton().logInfo(getClass(), "username: " + EmailModel.getUsername());
        LoggerUtility.getSingleton().logInfo(getClass(), "password: " + EmailModel.getPassword());
        LoggerUtility.getSingleton().logInfo(getClass(), "use ssl: " + EmailModel.isUseSSL());

        Properties props = System.getProperties();
        props.setProperty("mail.smtp.host", EmailModel.getSmtpSal());
        //props.put("mail.smtp.starttls.enable",EmailModel.isUseSSL()?"true":"false");
        //props.put("mail.smtp.ssl.enable",EmailModel.isUseSSL()?"true":"false");        
        if(0!=EmailModel.getSmtpSal().compareTo("smtp.yandex.com"))
        {
            //System.out.println("llego");
            //props.put("mail.smtp.EnableSSL.enable","true");
        }
        if(EmailModel.getSmtpPort()==465){
            props.put("mail.transport.protocol", "smtps");
            props.put("mail.smtps.ssl.trust", EmailModel.getSmtpSal());
            props.put("mail.smtps.ssl.enable", "true");
            
            // Accept only TLS 1.1 and 1.2
            props.setProperty("mail.smtps.ssl.protocols", "TLSv1.1 TLSv1.2");
        }
        else if(EmailModel.getSmtpPort()==587){
            
            // Enable STARTTLS
            props.put("mail.smtp.starttls.enable", "true");

            // Accept only TLS 1.1 and 1.2
            props.setProperty("mail.smtp.ssl.protocols", "TLSv1.1 TLSv1.2");
        }
        props.put("mail.smtp.auth", "true");
        props.put("mail.debug", "true");
        props.put("mail.smtp.port", EmailModel.getSmtpPort());
        props.put("mail.store.protocol", "pop3");
        props.put("mail.transport.protocol", "smtp");
        Session session = Session.getInstance(props,
                new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(EmailModel.getUsername(), EmailModel.getPassword());
                    }
                });
        session.setDebug(true);
        
        switch(Type_){
            
            case TEST:
                Message = getTestMessage(session, EmailModel.getUsername());
                break;
        }
        
        Transport trans = session.getTransport("smtp");
        trans.connect(EmailModel.getSmtpSal(), EmailModel.getSmtpPort(), EmailModel.getUsername(), EmailModel.getPassword());
        trans.sendMessage(Message, Message.getAllRecipients());
    }
    
    public enum Type{
        TEST
    }
    
    private Message getTestMessage(final Session session, final String emailTo) throws Exception {
        
        // -- Create a new message --        
        Message msg = new MimeMessage(session);                    
        msg.setFrom(new InternetAddress(emailTo));
        msg.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(emailTo, false));
        msg.setSubject("Prueba");
        msg.setContent("<h1>Prueba exitosa</h1>", "text/html");
        msg.setSentDate(new java.util.Date());

        // **************** Without Attachments ******************
        msg.setText("Prueba exitosa");
        
        return msg;
    }
}
