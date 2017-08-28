package io.mart.checker;

import io.swagger.client.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Service
@Slf4j
public class UserChecker {

    public void userHasName(User actualresult, String expectedName){
        log.info("CHECKER checking user has name {}", expectedName);
        assertThat(actualresult.getName()).as("Checking user name is correct").isEqualTo(expectedName);
    }

    public void pushWasSentToUser(List<String> recentCalls, String name){
        log.info("CHECKER checking calls received by mock service");
        assertThat(recentCalls).as("Checking number of stored calls in mock service").hasSize(1);
        assertThat(recentCalls.get(0)).contains(name);
    }
}
