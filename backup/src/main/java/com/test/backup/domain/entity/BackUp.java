package com.test.backup.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BackUp {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer backUpId;
    private Integer userId;
    private String username;
    private String email;
    private String todos;
    public String Status;
    public String date;


    public BackUp(Integer userId, String username, String email, String todos, String status, String date) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.todos = todos;
        Status = status;
        this.date = date;
    }

    public BackUp() {
    }

    public Integer getBackUpId() {
        return backUpId;
    }

    public void setBackUpId(Integer backUpId) {
        this.backUpId = backUpId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTodos() {
        return todos;
    }

    public void setTodos(String todos) {
        this.todos = todos;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
