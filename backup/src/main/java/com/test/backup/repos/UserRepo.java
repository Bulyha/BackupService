package com.test.backup.repos;

import com.test.backup.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
    User findByUserId(Integer userId);
}
