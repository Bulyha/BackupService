package com.test.backup.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AccountsBackup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer backupId;
    private String todos;

    public AccountsBackup(String todos) {
        this.todos = todos;
    }

    public AccountsBackup() {
    }

    public Integer getBackupId() {
        return backupId;
    }

    public void setBackupId(Integer backupId) {
        this.backupId = backupId;
    }

    public String getTodos() {
        return todos;
    }

    public void setTodos(String todos) {
        this.todos = todos;
    }
}
