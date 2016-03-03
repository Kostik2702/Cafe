package com.kos.cafe.service;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.kos.cafe.domain.User;

/**
 * Created by Олександр on 03.03.2016.
 */
public class MailService {
    private final static String USER_NAME ="userName";//add username of your email
    private final static String PASSWORD ="password";//add your password
    private final static String PARUS_EMAIL ="parusEmail@gmail.com";//add your email
    private User user;

    public void sendEmail(User user,String subject,String messageText){
        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(USER_NAME, PASSWORD);
                    }
                });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(PARUS_EMAIL));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(user.getEmail()));
            message.setSubject(subject);
            message.setText(messageText);
            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }
}
