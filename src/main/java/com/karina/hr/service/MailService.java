package com.karina.hr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MailService {


    @Autowired
    public JavaMailSender javaMailSender;

    void sendEmail(String[] employeeEmails, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(employeeEmails);
        message.setSubject(subject);
        message.setText(text);
        javaMailSender.send(message);
    }

}
