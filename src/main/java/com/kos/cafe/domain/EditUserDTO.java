package com.kos.cafe.domain;


public class EditUserDTO {
    String login;
    String password;
    String name;
    String surname;
    String email;
    String role;
    long id;

    public EditUserDTO(String login, String password, String name, String surname, String email, String role, long id) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.role = role;
        this.id = id;
    }

    public EditUserDTO(String login,  String name, String surname, String email, String role, long id) {
        this.login = login;

        this.name = name;
        this.surname = surname;
        this.email = email;
        this.role = role;
        this.id = id;
    }

    public EditUserDTO() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
