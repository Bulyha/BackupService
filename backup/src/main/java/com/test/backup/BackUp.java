package com.test.backup;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BackUp {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Integer backUpId;
    private  Integer toDOItemId;
    private  String username;
    private  String Subject;
    private String dueDate;
    public String Status;
    public String date;

    public BackUp(Integer toDOItemId, String username, String subject, String dueDate, String status, String date) {
        this.toDOItemId = toDOItemId;
        this.username = username;
        Subject = subject;
        this.dueDate = dueDate;
        Status = status;
        this.date = date;
    }

    public BackUp() {
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public Integer getBackUpId() {
        return backUpId;
    }

    public void setBackUpId(Integer backUpId) {
        this.backUpId = backUpId;
    }

    public Integer getToDOItemId() {
        return toDOItemId;
    }

    public void setToDOItemId(Integer toDOItemId) {
        this.toDOItemId = toDOItemId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

