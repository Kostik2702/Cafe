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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NewsPreview that = (NewsPreview) o;

        if (id != that.id) return false;
        if (subject != null ? !subject.equals(that.subject) : that.subject != null) return false;
        return !(text != null ? !text.equals(that.text) : that.text != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        return result;
    }
}
