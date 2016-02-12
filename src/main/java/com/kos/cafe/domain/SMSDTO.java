package com.kos.cafe.domain;

/**
 * Created by Hrytsuk.K.O on 12.02.2016.
 */
public class SMSDTO {
    String message;

    public SMSDTO(String message) {
        this.message = message;
    }

    public SMSDTO() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
