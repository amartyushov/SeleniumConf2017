package io.mart.providers;

import io.mart.util.KeyValueHolder;
import io.swagger.client.model.Address;
import io.swagger.client.model.Book;
import io.swagger.client.model.User;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserProvider {

    public User buildUser(User dto, List<KeyValueHolder> params){
        for (KeyValueHolder entry : params){
            String value = entry.getValue();

            switch (entry.getKey()){
                case ("name"):
                    dto.setName(value);
                    break;
                case ("pushNotificationMessage"):
                    dto.pushNotificationMessage(value);
                    break;
                default: throw new IllegalArgumentException("Unknown parameter for User object");
            }
        }
        return dto;
    }

    public User defaultUser(){
        return new User()
                .address(new Address().zip(1000).street("Street").country("DE"))
                .books(Arrays.asList(new Book().title("Title").author("Author")))
                .name("DEFAULT_NAME")
                .pushNotificationMessage("DEFAULT PUSH NOTIFICATION");
    }
}
