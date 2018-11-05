package com.test.backup;

import com.test.backup.domain.entity.User;
import com.test.backup.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;


@RestController
public class GreetingController {
    @Autowired
    private UserRepo userRepo;

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    // Method that greets the user
    @RequestMapping(path="/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="User") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    // This metod returns the list of all users
    @GetMapping(path="/allusers")
    public @ResponseBody
    Iterable<User> getAllUsers() {
        return userRepo.findAll();
    }
}
