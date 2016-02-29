package com.kos.cafe.domain;


public class EditNewsDTO extends NewsDTO {
    long id;

    public EditNewsDTO(String subject, String text, long id) {
        super(subject, text);
        this.id = id;
    }

    public EditNewsDTO(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public EditNewsDTO(){
        super();
    }
}
