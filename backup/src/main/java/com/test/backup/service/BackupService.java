package com.test.backup.service;

import com.test.backup.controller.BackupAccountsController;
import com.test.backup.domain.DTOToDo;
import com.test.backup.domain.DTOUser;
import com.test.backup.domain.entity.AccountsBackup;
import com.test.backup.domain.entity.BackUp;
import com.test.backup.domain.entity.enums.Status;
import com.test.backup.repos.AccountsBackupRepo;
import com.test.backup.repos.BackUpRepo;
import com.test.backup.repos.ToDoRepo;
import com.test.backup.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Service
public class BackupService {
    @Autowired
    private BackUpRepo backUpRepo;
    @Autowired
    private UserService userService;
    @Autowired
    private AccountsBackupRepo accountsBackupRepo;

    public static final Logger logger = Logger.getLogger(BackupService.class.getName());

    //----ADD BACKUP METHOD----
    // Adding new backup item. This method get the Todo`s fields and set them into backup`s fields
    // Return the list of backups with new backup

    @GetMapping(path = "/addbackup/{id}")
    public @ResponseBody BackUp NewBackUp
    (@PathVariable("id") Integer id) {

        DTOUser dtoUser = userService.findAll().get(id);
        List<DTOToDo> todos = dtoUser.getTodos();

        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy");
        String date = String.valueOf(formatForDateNow.format(dateNow));

        //Insert them into BackUp`s fields
        BackUp b = new BackUp();
        b.setDate(date);
        b.setUserId(dtoUser.getUserId());
        b.setStatus(String.valueOf(Status.OK));
        b.setEmail(dtoUser.getEmail());
        b.setTodos(String.valueOf(todos));
        b.setUsername(dtoUser.getUsername());
        backUpRepo.save(b);
        return b;
    }


    //----BACKUP ACCOUNTS METHOD----
    // Return the backIds in format like "backupId" = <backupId>

    @GetMapping(path = "/backups_acc")
    public String accountsBackup(Map<String, Object> model){

        List<DTOUser> allUsers = userService.findAll();
        AccountsBackup accountsBackup = new AccountsBackup();
        for (DTOUser i:allUsers) {
            List<DTOToDo> todos = i.getTodos();
            for (int j = 0; j <= todos.toArray().length; j++){
                try {
                    String dtoToDo = String.valueOf(todos.get(j));
                    accountsBackup.setTodos(dtoToDo);
                    accountsBackupRepo.save(accountsBackup);
                }catch (Exception e){
                    logger.warning(String.valueOf(e));
                }
            }
        }
        List<AccountsBackup> allTodoBackups = accountsBackupRepo.findAll();
        try{
            for (AccountsBackup i:allTodoBackups) {
                Integer idBackUp = i.getBackupId();
                model.put("Backup '"+String.valueOf(idBackUp)+"' ", idBackUp);
            }
        }catch (Exception e){
            logger.warning(String.valueOf(e));
        }
        return "'"+model+"'";
    }

    //----BACKUP EXPORT METHOD----
    // backupExport method return the content of a specified backup.
    // Just enter the id of the certain backup you need to export and method return you this backup

    @GetMapping(path = "/exports/{id}")
    public @ResponseBody
    BackUp backupExport(
            @PathVariable("id") Integer backupId) {

        BackUp backUp = new BackUp();
        if(backupId!=null){
            backUp = backUpRepo.findByBackUpId(backupId);
        }else{
            logger.warning("There are no backups for this id");
        }
        return backUp;
    }

    //----BACKUP LIST METHOD----
    //     This method return the list of all backups

    @GetMapping(path = "/backups")
    public String backupList(
            Map<String, Object> model) {

        List<BackUp> backUps = backUpRepo.findAll();

        for (BackUp i: backUps) {
            model.put("Backup '"+String.valueOf(i.getBackUpId())+"' ", i.getBackUpId());
            model.put("Date ", i.getDate());
            model.put("Status " , i.getStatus());
        }
        return "'"+model+"'";
    }
}
