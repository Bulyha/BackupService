package com.test.backup.controller;

import com.test.backup.domain.DTOUser;
import com.test.backup.domain.entity.BackUp;
import com.test.backup.repos.BackUpRepo;
import com.test.backup.service.BackupService;
import com.test.backup.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class BackupListController {
    @Autowired
    private BackupService backupService;
    @Autowired
    private UserService userService;

//     This method return the list of all backups
    @GetMapping(path = "/backups")
    public String backupList(
            Map<String, Object> model) {
        return backupService.backupList(model);
    }

    @GetMapping(path = "/users")
    public List<DTOUser> getListOfBackups(){
        return userService.findAll();
    }
}
