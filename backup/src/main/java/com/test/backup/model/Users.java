package com.test.backup.model;

import com.test.backup.domain.DTOUser;
import lombok.Data;

import java.util.List;

@Data
public class Users {
    private List<DTOUser> items;

    public Users(List<DTOUser> items) {
        this.items = items;
    }

    public Users() {
    }

    public List<DTOUser> getItems() {
        return items;
    }

    public void setItems(List<DTOUser> items) {
        this.items = items;
    }
}
