package com.test.backup.controller;

import com.test.backup.BackUp;
import com.test.backup.repos.BackUpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class BackupListController {
    @Autowired
    private BackUpRepo backUpRepo;

    // This method return the list of backups
    @GetMapping(path = "/list")
    public String backupList(
            Map<String, Object> model) {

        List<BackUp> backUps = backUpRepo.findAll();

        for (BackUp i: backUps) {
            model.put("Backup '"+String.valueOf(i.getBackUpId())+"'", i.getBackUpId());
            model.put("Date '"+String.valueOf(i.getDate())+"'", i.getDate());
            model.put("Status '"+String.valueOf(i.getStatus())+"'", i.getStatus());
        }
        return "'"+model+"'";
    }
}

