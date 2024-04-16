package com.spring_boot.email_sender;

import com.spring_boot.email_sender.services.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@SpringBootTest
public class EmailSenderTest {

    @Autowired
    private EmailService emailService;


    @Test
    void emailSendTest()
    {
        System.out.println("Sending Email");
        emailService.sendEmail("www.adhishpawar@gmail.com","This is Email From Spring Boot","This email is Send while Using Spring boot");
    }

    @Test
    void  sendEmailWithHtml()
    {
        String html= "" +
                "<h1 style='color-red; border:1px solid red'>Welcome To Adhish's World</h1>" +
                "";
        emailService.sendEmailWithHtml("www.adhishpawar@gmail.com","This is Email From Spring Boot",html);
    }

    @Test
    void sendEmailWithFile(){
        emailService.sendEmailWithFile("www.adhishpawar@gmail.com",
                "Email with Spring Application",
                "This  Email Contain  File" ,
                new File("E:\\Projects\\email_sender\\src\\main\\resources\\static\\img.png"));
    }

    @Test
    void sendEmailWithFileWithStream(){
        File file = new File("E:\\Projects\\email_sender\\src\\main\\resources\\static\\img.png");
        try {
            InputStream is = new FileInputStream(file);
            emailService.sendEmailWithFile("www.adhishpawar@gmail.com",
                    "Email with Spring Application",
                    "This  Email Contain  File" ,is
                    );
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
