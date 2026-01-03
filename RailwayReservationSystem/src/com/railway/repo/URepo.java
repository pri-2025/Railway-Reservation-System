package com.railway.repo;

import java.util.*;
import com.railway.model.User;

public class URepo {

    private static Map<String, User> users = new HashMap<>();

    public void save(User u) {
        users.put(u.getUsername(), u);
    }

    public User getByUsername(String username) {
        return users.get(username);
    }

    public boolean exists(String username) {
        return users.containsKey(username);
    }
}
