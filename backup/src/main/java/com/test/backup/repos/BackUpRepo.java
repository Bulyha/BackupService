package com.test.backup.repos;

import com.test.backup.BackUp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BackUpRepo extends JpaRepository<BackUp, Integer> {
    BackUp findByBackUpId(Integer backUpId);

    //BackUp findFirstByBackUpId(Integer backUpId);
}
