package com.test.backup.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

//@JsonInclude(JsonInclude.Include.NON_EMPTY)

@JsonIgnoreProperties(ignoreUnknown = true)
public class DTOToDo{
    @JsonProperty("subject")
    public String subject;
    @JsonProperty("dueDate")
    public String dueDate;
    @JsonProperty("done")
    public String done;

    public DTOToDo() {
    }

    public DTOToDo(String toDoSubject, String dueDate, String done) {
        this.subject = toDoSubject;
        this.dueDate = dueDate;
        this.done = done;
    }
    @JsonProperty("subject")
    public String getSubject() {
        return subject;
    }
    @JsonProperty("subject")
    public void setSubject(String subject) {
        this.subject = subject;
    }
    @JsonProperty("dueDate")
    public String getDueDate() {
        return dueDate;
    }
    @JsonProperty("dueDate")
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
    @JsonProperty("done")
    public String getDone() {
        return done;
    }
    @JsonProperty("done")
    public void setDone(String done) {
        this.done = done;
    }
}
