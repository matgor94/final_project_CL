package com.github.matgor.workshop.Domain.Service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    private final JavaMailSender javaMailSender;

    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendEmail(String to, String subject, String contet){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setFrom("Warsztat motoryzacyjny - centrum haseł<cytrox94@gmail.com>");
        message.setSubject(subject);
        message.setText(contet);
        javaMailSender.send(message);
    }

}
