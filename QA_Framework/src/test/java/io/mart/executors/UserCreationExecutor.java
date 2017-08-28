package io.mart.executors;

import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.api.UsersApi;
import io.swagger.client.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserCreationExecutor {

    private UsersApi usersApi = new UsersApi(
            new ApiClient().setBasePath("http://localhost:8080/"));

    public User createUser(User user){
        log.info("EXECUTOR: creating user {}", user);
        try {
            return usersApi.createUser(user);
        } catch (ApiException e) {
            throw new RuntimeException(e);
        }
    }

    public User getUserByName(String name){
        log.info("EXECUTOR: getting user by name {}", name);
        try {
            return usersApi.getUserByName(name);
        } catch (ApiException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void deleteUsers(){
        log.info("EXECUTOR: Deleting all users");
        try {
            usersApi.deleteUsers();
        } catch (ApiException e) {
            throw new RuntimeException(e);
        }
    }

    public User sendingPushNotification(User user){
        log.info("EXECUTOR: Sending push notification to user {}", user);
        try {
            return usersApi.notifyUser(user);
        } catch (ApiException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
