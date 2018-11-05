package com.test.backup.controller;

import com.test.backup.domain.entity.BackUp;
import com.test.backup.repos.BackUpRepo;
import com.test.backup.service.BackupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
public class BackupExportController {
    @Autowired
    private BackUpRepo backUpRepo;
    @Autowired
    private BackupService backupService;

    public static final Logger logger = Logger.getLogger(BackupExportController.class.getName());

    // backupExport method return the content of a specified backup.
    // Just enter the id of the certain backup you need to export and method return you this backup
    @GetMapping(path = "/exports/{id}")
    public @ResponseBody
    BackUp backupExport(
            @PathVariable("id") Integer backupId) {
        return backupService.backupExport(backupId);
    }
}
