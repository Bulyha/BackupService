package com.test.backup.repos;

import com.test.backup.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
    User findByUserId(Integer userId);
}
