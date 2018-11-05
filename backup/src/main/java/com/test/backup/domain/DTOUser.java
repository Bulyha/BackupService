package com.test.backup.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DTOUser{
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("username")
    private String username;
    @JsonProperty("email")
    private String email;
    @JsonProperty("todos")
    private List<DTOToDo> todos;

    public DTOUser(Integer id, String username, String email, List<DTOToDo> todos) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.todos = todos;
    }

    public DTOUser() {
    }

    @JsonProperty("id")
    public Integer getUserId() {
        return id;
    }
    @JsonProperty("id")
    public void setUserId(Integer userId) {
        this.id = userId;
    }
    @JsonProperty("username")
    public String getUsername() {
        return username;
    }
    @JsonProperty("username")
    public void setUsername(String username) {
        this.username = username;
    }
    @JsonProperty("email")
    public String getEmail() {
        return email;
    }
    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }
    @JsonProperty("todos")
    public List<DTOToDo> getTodos() {
        return todos;
    }
    @JsonProperty("todos")
    public void setTodos(List<DTOToDo> todos) {
        this.todos = todos;
    }
}
