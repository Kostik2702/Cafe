package com.kos.cafe.domain;

/**
 * Created by Hrytsuk.K.O on 12.02.2016.
 */
public class NewsPreview {
    private long id;
    private String subject;
    private String text;

    public NewsPreview(String subject, String text, long id) {
        this.id = id;
        this.subject = subject;
        if (text.length()>150){
            this.text = text.substring(0,149);
        }   else {
            this.text = text;
        }

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
