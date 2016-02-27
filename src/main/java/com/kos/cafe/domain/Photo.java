package com.kos.cafe.domain;

import javax.persistence.*;
import java.util.Arrays;

@SuppressWarnings("ALL")
@Entity
@Table(name = "photos")
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "body")
    private byte [] body;

    public Photo(String name, byte[] body) {
        this.name = name;
        this.body = body;
    }

    public Photo() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getBody() {
        return body;
    }

    public void setBody(byte[] body) {
        this.body = body;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Photo photo = (Photo) o;

        if (id != photo.id) return false;
        if (name != null ? !name.equals(photo.name) : photo.name != null) return false;
        if (!Arrays.equals(body, photo.body)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (body != null ? Arrays.hashCode(body) : 0);
        return result;
    }
}
