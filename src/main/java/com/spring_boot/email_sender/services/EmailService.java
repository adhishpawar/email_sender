package com.spring_boot.email_sender.services;

import java.io.File;
import java.io.InputStream;

public interface EmailService {

    //Send Email to Single Person
    void sendEmail(String to,String subject, String message);

    //Send Email to  Multiple Person
    void sendEmail(String []to,String subject, String message);

    //Send Email sendEmailWithHtml
    void sendEmailWithHtml(String to, String subject, String htmlContent);

    //Void Send Email  with File

    void sendEmailWithFile(String to, String subject, String message, File file);


    void sendEmailWithFile(String to, String subject, String message, InputStream is);


}
