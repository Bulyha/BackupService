package com.test.backup.service;

import com.google.common.collect.ImmutableList;
import com.test.backup.domain.entity.ToDo;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

@Service
public class ToDoService {
    @Autowired
    private StackExchangeClient stackExchangeClient;

    public List<ToDo> findAll(){
        return stackExchangeClient.getToDo().stream()
                .map(this::toToDo)
                .collect(collectingAndThen(toList(), ImmutableList::copyOf));
    }

    private ToDo toToDo(@NonNull ToDo input){
        return new ToDo(
                input.getUserId(),
                input.getToDoSubject(),
                input.getDueDate(),
                input.getDone()
        );
    }
}
