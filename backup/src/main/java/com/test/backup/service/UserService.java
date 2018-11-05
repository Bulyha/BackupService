package com.test.backup.service;

import com.google.common.collect.ImmutableList;
import com.test.backup.domain.DTOUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

@Service
public class UserService {
    @Autowired
    private StackExchangeClient stackExchangeClient;

    public List<DTOUser> findAll(){
        return stackExchangeClient.getUsers("http://localhost:9000/users").stream()
                .map(this::toDTOUser)
                .collect(collectingAndThen(toList(), ImmutableList::copyOf));
    }
    public List<DTOUser> findUser(String id){
        return stackExchangeClient.getUsers("http://localhost:9000/users"+id);
    }
    private DTOUser toDTOUser(DTOUser input){
        return new DTOUser(
                input.getUserId(),
                input.getUsername(),
                input.getEmail(),
                input.getTodos()
        );
    }

}
