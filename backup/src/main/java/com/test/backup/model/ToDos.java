package com.test.backup.model;

import com.test.backup.domain.entity.ToDo;
import lombok.Data;

import java.util.List;
@Data
public class ToDos {
    private List<ToDo> itemsToDo;

    public List<ToDo> getItems() {
        return itemsToDo;
    }

    public void setItems(List<ToDo> items) {
        this.itemsToDo = items;
    }
}
