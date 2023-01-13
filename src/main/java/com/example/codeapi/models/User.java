package com.example.codeapi.models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity(name = "account")
//@JsonIgnoreProperties({"hibernateLazyInitializer"})

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public User(){

    }

    private String username;
    private String password;
    @CreationTimestamp
    private Timestamp datecreate;


    public User(long id, String username, String password, Timestamp datecreate) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.datecreate = datecreate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateCreate() {
        return datecreate;
    }

    public void setDateCreate(Timestamp datecreate) {
        this.datecreate = datecreate;
    }
}
