package com.kos.cafe.domain;


public class EmailMessageDTO {

    String subject;
    String text;
    String toAdress;

    public EmailMessageDTO(String subject, String text, String toAdress) {
        this.subject = subject;
        this.text = text;
        this.toAdress = toAdress;
    }

    public EmailMessageDTO() {
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getToAdress() {
        return toAdress;
    }

    public void setToAdress(String toAdress) {
        this.toAdress = toAdress;
    }
}
