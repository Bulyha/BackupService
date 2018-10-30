package com.test.backup;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer toDoItemId;
    public Integer userId;
    public String toDoSubject;
    public String DueDate;
    public String done;

    public ToDo() {
    }

    public ToDo(Integer userId, String toDoSubject, String dueDate, String done) {
        this.userId = userId;
        this.toDoSubject = toDoSubject;
        DueDate = dueDate;
        this.done = done;
    }

    /*    public ToDo(Integer toDoItemId, String toDoSubject, String dueDate, String done) {
        this.toDoItemId = toDoItemId;
        this.toDoSubject = toDoSubject;
        DueDate = dueDate;
        this.done = done;
    }*/

    public Integer getToDoItemId() {
        return toDoItemId;
    }

    public void setToDoItemId(int toDoItemId) {
        this.toDoItemId = toDoItemId;
    }

    public String getToDoSubject() {
        return toDoSubject;
    }

    public void setToDoSubject(String toDoSubject) {
        this.toDoSubject = toDoSubject;
    }

    public String getDueDate() {
        return DueDate;
    }

    public void setDueDate(String dueDate) {
        DueDate = dueDate;
    }

    public String getDone() {
        return done;
    }

    public void setDone(String done) {
        this.done = done;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
