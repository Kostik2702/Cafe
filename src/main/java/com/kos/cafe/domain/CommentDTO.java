package com.kos.cafe.domain;


public class CommentDTO {
    String text;

    public CommentDTO(String text) {
        this.text = text;
    }

    public CommentDTO() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
