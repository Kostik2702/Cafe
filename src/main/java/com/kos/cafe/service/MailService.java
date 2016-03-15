package com.kos.cafe.service;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.kos.cafe.domain.EmailMessageDTO;
import com.kos.cafe.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MailService implements IEmailService {
/*
    private final static String PASSWORD ="";//add your password
    private final static String PALUBA_EMAIL ="";//add your email

*/
    @Autowired
    UserService userService;



    @Override
    public void sendAll(User admin, EmailMessageDTO messageDTO) {
        List<User> users = userService.getAll();
        for (User user : users) {
            if (!user.getEmail().equals(admin.getEmail())){
                sendEmail(user,messageDTO,admin);
            }
        }
    }
    @Override
    public void sendEmail(User user, EmailMessageDTO messageDTO, final User admin){
        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(admin.getEmail(), admin.getPassword());
                    }
                });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(admin.getEmail()));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(user.getEmail()));
            message.setSubject(messageDTO.getSubject());
            message.setText(messageDTO.getText());
            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }
}
