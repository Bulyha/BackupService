package com.test.backup.controller;

import com.test.backup.BackUp;
import com.test.backup.repos.BackUpRepo;
import com.test.backup.repos.ToDoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BackupListController {
    @Autowired
    private ToDoRepo toDoRepo;
    @Autowired
    private BackUpRepo backUpRepo;

    // This method return the list of all backups
    @GetMapping(path = "/list")
    public Iterable<BackUp> backupList() {
        return backUpRepo.findAll();
    }
}
