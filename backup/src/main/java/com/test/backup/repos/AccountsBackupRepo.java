package com.test.backup.repos;

import com.test.backup.domain.entity.AccountsBackup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountsBackupRepo extends JpaRepository<AccountsBackup, Integer> {
}
