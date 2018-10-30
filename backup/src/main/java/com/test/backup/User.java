package com.test.backup;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Integer userId;
    private  String userName;
    private  String email;
    private  String listOfToDo;

    public User() {
    }

    public User(Integer userId, String userName, String email, String listOfToDo) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.listOfToDo = listOfToDo;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getListOfToDo() {
        return listOfToDo;
    }

    public void setListOfToDo(String listOfToDo) {
        this.listOfToDo = listOfToDo;
    }
}
