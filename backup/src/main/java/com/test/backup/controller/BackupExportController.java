package com.test.backup.controller;

import com.test.backup.BackUp;
import com.test.backup.repos.BackUpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BackupExportController {
    @Autowired
    private BackUpRepo backUpRepo;

    // backupExport method return the content of a specified backup.
    // Just enter the id of the certain backup you need to export and method return you this backup
    @GetMapping(path = "/export/{id}")
    public @ResponseBody
    BackUp backupExport(
            @PathVariable("id") Integer backupId) {

        BackUp backUp = new BackUp();
        if(backupId!=null){
            backUp = backUpRepo.findByBackUpId(backupId);
        }else{
            System.out.println("There are no backups for this id");
        }
        return backUp;
    }
}
