package com.test.backup.controller;

import com.test.backup.domain.entity.BackUp;
import com.test.backup.domain.DTOToDo;
import com.test.backup.domain.DTOUser;
import com.test.backup.domain.entity.enums.Status;
import com.test.backup.repos.BackUpRepo;
import com.test.backup.repos.ToDoRepo;
import com.test.backup.repos.UserRepo;
import com.test.backup.service.BackupService;
import com.test.backup.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class AddNewBackupController {
    @Autowired
    private BackupService backupService;

    // Adding new backup item. This method get the Todo`s fields and set them into backup`s fields
    // Return the list of backups with new backup
    @GetMapping(path = "/addbackup/{id}")
    public @ResponseBody
    BackUp addNewBackUp
            (@PathVariable("id") Integer id) {
        return backupService.NewBackUp(id);
    }
}
