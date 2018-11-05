package com.test.backup.controller;

import com.test.backup.domain.entity.User;
import com.test.backup.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddNewUserController {
    @Autowired
    private UserRepo userRepo;

    // Method that create a new user in user repository and return the list of users
    @GetMapping("/adduser/{username}/{email}/{listOfToDo}")
    public @ResponseBody
    Iterable<User> addNewUser(
            @PathVariable("username") String userName,
            @PathVariable("email") String email,
            @PathVariable("email") String listOfToDo) {
        User n = new User();
        n.setUserName(userName);
        n.setEmail(email);
        n.setListOfToDo(listOfToDo);
        userRepo.save(n);
        return userRepo.findAll();
    }
}
