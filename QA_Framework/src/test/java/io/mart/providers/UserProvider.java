package io.mart.providers;

import io.mart.util.KeyValueHolder;
import io.swagger.client.model.User;
import org.springframework.stereotype.Service;

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
                default: throw new IllegalArgumentException("Unknown parameter for User object");
            }
        }
        return dto;
    }
}
