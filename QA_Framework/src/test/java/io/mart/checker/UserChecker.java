package io.mart.checker;

import io.swagger.client.model.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import static org.assertj.core.api.Assertions.assertThat;

@Component
public class UserChecker {

    public void userHasName(User actualresult, String expectedName){
        assertThat(actualresult.getName()).as("Checking user name is correct").isEqualTo(expectedName);
    }
}
