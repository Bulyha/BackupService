package com.test.backup.controller;

import com.test.backup.domain.entity.AccountsBackup;
import com.test.backup.domain.DTOToDo;
import com.test.backup.domain.DTOUser;
import com.test.backup.repos.AccountsBackupRepo;
import com.test.backup.repos.BackUpRepo;
import com.test.backup.service.BackupService;
import com.test.backup.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@RestController
public class BackupAccountsController {
    @Autowired
    private BackupService backupService;

    // Return the backIds in format like "backupId" = <backupId>
    @GetMapping(path = "/backups_acc")
    public String accountsBackup(Map<String, Object> model){
        return backupService.accountsBackup(model);
    }
}
