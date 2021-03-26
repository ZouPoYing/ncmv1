package com.graduation.util;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class Email_Authenticator extends Authenticator {
    
	String userName = null;
    String password = null;
    
    public Email_Authenticator() {
    }
    
    public Email_Authenticator(String username, String password) {
        this.userName = username;
        this.password = password;
    }
    
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(userName, password);
    }
}

