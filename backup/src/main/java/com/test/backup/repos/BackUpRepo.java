package com.test.backup.repos;

import com.test.backup.domain.entity.BackUp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BackUpRepo extends JpaRepository<BackUp, Integer> {
    BackUp findByBackUpId(Integer backUpId);

    //BackUp findFirstByBackUpId(Integer backUpId);
}
