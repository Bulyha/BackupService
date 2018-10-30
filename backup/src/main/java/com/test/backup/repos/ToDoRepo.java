package com.test.backup.repos;

import com.test.backup.ToDo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ToDoRepo extends CrudRepository<ToDo, Integer> {
    ToDo findByToDoItemId(Integer toDoItemId);
}
