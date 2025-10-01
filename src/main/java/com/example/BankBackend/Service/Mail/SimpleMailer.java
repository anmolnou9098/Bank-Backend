package com.example.BankBackend.Service.Mail;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SimpleMailer {

    private final JavaMailSender mailSender;
    @Value("${spring.mail.username}")
      private String sendermail;

    public void sendMail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(sendermail);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);


        mailSender.send(message);
    }
}
