package com.kos.cafe.service;


import com.kos.cafe.domain.EmailMessageDTO;
import com.kos.cafe.domain.User;

public interface IEmailService {

    void sendAll(User admin, EmailMessageDTO messageDTO);
    void sendEmail(User user, EmailMessageDTO emailMessageDTO, User admin);
}
