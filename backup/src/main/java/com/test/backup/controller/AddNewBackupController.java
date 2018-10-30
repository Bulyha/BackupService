package com.test.backup.controller;

import com.test.backup.BackUp;
import com.test.backup.ToDo;
import com.test.backup.User;
import com.test.backup.repos.BackUpRepo;
import com.test.backup.repos.ToDoRepo;
import com.test.backup.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AddNewBackupController {
    @Autowired
    private ToDoRepo toDoRepo;
    @Autowired
    private BackUpRepo backUpRepo;
    @Autowired
    private UserRepo userRepo;

    // Adding new backup item. This method get the Todo`s fields and set them into backup`s fields
    // Return the list of backups with new backup
    @GetMapping(path = "/addbackup/{id}")
    public @ResponseBody
    BackUp addNewBackUp
            (//@RequestParam(required = false, defaultValue = "Bob") String username,
             @PathVariable("id") Integer toDoItemId) {
        ToDo toDo = new ToDo();
        if(toDoItemId!=null){
            toDo = toDoRepo.findByToDoItemId(toDoItemId);
        }else{
            System.out.println("There are no ToDos for this id");
        }
        //Get the ToDos fields
        Integer userId = toDo.getUserId();
        String dueDate = toDo.getDueDate();
        String subject = toDo.getToDoSubject();
        String done = toDo.getDone();

        User user = new User();
        if(userId!=null){
            user = userRepo.findByUserId(userId);
        }else{
            System.out.println("There are no ToDos for this id");
        }
        String username = "";
        if (user.getUserName() != null){
            username = user.getUserName();
        }else {
            username = "bob"; //default value, if there are no records in User table
        }

        //Insert them into BackUp`s fields
        BackUp b = new BackUp();
        b.setToDOItemId(toDoItemId);
        b.setDueDate(dueDate);
        b.setStatus(done);
        b.setSubject(subject);
        b.setUsername(username);
        backUpRepo.save(b);
        return b;
    }
}
