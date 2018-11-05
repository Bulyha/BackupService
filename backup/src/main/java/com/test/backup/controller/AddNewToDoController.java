package com.test.backup.controller;

import com.test.backup.domain.entity.ToDo;
import com.test.backup.repos.ToDoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AddNewToDoController {
    @Autowired
    private ToDoRepo toDoRepo;
    // This method add new ToDo.
    // Parameters sends to the method via URL. The sequence looks like this: /addtodo/{subject}/{dueDate}/{done}
    // Type the parameters in URL to create new ToDo
    @GetMapping(path = "/addtodo/{userId}/{toDoSubject}/{dueDate}/{done}")
    public @ResponseBody
    Iterable<ToDo> addNewToDo
            (@PathVariable("userId") Integer userID,
             @PathVariable("toDoSubject") String toDoSubject,
             @PathVariable("dueDate") String dueDate
                    ,@PathVariable("done") String done) {

        ToDo n = new ToDo();
        n.setUserId(userID);
        n.setToDoSubject(toDoSubject);
        n.setDueDate(dueDate);
        n.setDone(done);
        toDoRepo.save(n);
        return toDoRepo.findAll();
    }
}
