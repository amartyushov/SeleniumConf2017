package io.mart.checker;

import io.swagger.client.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import static org.assertj.core.api.Assertions.assertThat;

@Component
@Slf4j
public class UserChecker {

    public void userHasName(User actualresult, String expectedName){
        log.info("Checking created user has name {}", expectedName);
        assertThat(actualresult.getName()).as("Checking user name is correct").isEqualTo(expectedName);
    }
}
