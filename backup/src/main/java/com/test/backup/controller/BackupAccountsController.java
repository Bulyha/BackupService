package com.test.backup.controller;

import com.test.backup.BackUp;
import com.test.backup.repos.BackUpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class BackupAccountsController {
    @Autowired
    private BackUpRepo backUpRepo;
    
    // Return the backIds in format like "backupId" = <backupId>
    @GetMapping(path = "/accounts")
    public String accountsBackup(Map<String, Object> model){

        List<BackUp> backUps = backUpRepo.findAll();
        try{
            for (BackUp i: backUps) {
                Integer idBackUp = i.getBackUpId();
                model.put("Backup '"+String.valueOf(idBackUp)+"' ", idBackUp);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return "'"+model+"'";
    }
}
