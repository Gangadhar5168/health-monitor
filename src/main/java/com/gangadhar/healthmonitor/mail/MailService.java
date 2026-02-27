package com.gangadhar.healthmonitor.mail;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
public class MailService {
    private final Properties config = new Properties();

    public MailService() {
        try (InputStream input = getClass()
                .getClassLoader()
                .getResourceAsStream("config.properties")) {

            config.load(input);

        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    public void sendEmail(String subject, String htmlContent) {

        Properties props = new Properties();
        props.put("mail.smtp.host", config.getProperty("mail.smtp.host"));
        props.put("mail.smtp.port", config.getProperty("mail.smtp.port"));
        props.put("mail.smtp.auth", config.getProperty("mail.smtp.auth"));
        props.put("mail.smtp.starttls.enable", config.getProperty("mail.smtp.starttls.enable"));

        Session session = Session.getInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(
                                config.getProperty("mail.username"),
                                config.getProperty("mail.password")
                        );
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(config.getProperty("mail.username")));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(config.getProperty("mail.recipient"))
            );
            message.setSubject(subject);
            message.setContent(htmlContent, "text/html; charset=utf-8");

            Transport.send(message);

            System.out.println("Email sent successfully!");

        } catch (MessagingException e) {
            throw new RuntimeException("Failed to send email", e);
        }
    }
}

