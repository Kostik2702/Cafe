package com.kos.cafe.domain;

import javax.persistence.*;

@SuppressWarnings("all")
@Entity
@Table(name = "news")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class News {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "subject")
    private String subject;
    @Column(name = "text")
    private String text;

    public News(String subject, String text) {
        this.subject = subject;
        this.text = text;
    }

    public News() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        News news = (News) o;

        if (id != news.id) return false;
        if (subject != null ? !subject.equals(news.subject) : news.subject != null) return false;
        if (text != null ? !text.equals(news.text) : news.text != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        return result;
    }
}
