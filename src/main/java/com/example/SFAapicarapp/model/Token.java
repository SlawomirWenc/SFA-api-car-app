package com.example.SFAapicarapp.model;

import com.example.SFAapicarapp.model.User;

import javax.persistence.*;

@Entity
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String value;

    @OneToOne
    private User user;

    public Token() {
    }

    public Token(String value, User user) {
        this.value = value;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Token{" +
                "id=" + id +
                ", value='" + value + '\'' +
                ", user=" + user +
                '}';
    }
}
