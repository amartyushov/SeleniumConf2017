package io.mart;

import io.mart.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Component
public class UserRepository {

    private Map<String, User> users = new HashMap<>();

    public User createUsers(User user) {
        if (users.containsKey(user.getName())){
            throw new IllegalArgumentException("There is a user with name " + user.getName());
        }
        users.put(user.getName(), user);
        log.info("User was created {}", user);
        return user;
    }

    public Collection<User> allUsers() {
        return users.values();
    }

    public User getByName(String name) {
        return users.get(name);
    }

    public void deleteUsers() {
        users = new HashMap<>();
        log.info("Users were deleted");
    }
}
