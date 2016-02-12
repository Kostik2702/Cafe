package com.kos.cafe.domain;

public class NewsDTO {
   String subject;
   String text;

    public NewsDTO(String subject, String text) {
        this.subject = subject;
        this.text = text;
    }

    public NewsDTO() {
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
}
