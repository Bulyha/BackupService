package com.test.backup.repos;

import com.test.backup.domain.entity.ToDo;
import org.springframework.data.repository.CrudRepository;

public interface ToDoRepo extends CrudRepository<ToDo, Integer> {
    ToDo findByToDoItemId(Integer toDoItemId);
}
