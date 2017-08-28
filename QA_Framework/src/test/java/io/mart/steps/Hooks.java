package io.mart.steps;

import cucumber.api.java.Before;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class Hooks extends AbstractSteps{

    @Before("@deleteAll")
    public void deleteAll() throws IOException {
        log.info("Executing @deleteAll hook");
        userExecutor.deleteUsers();

        mockServiceExecutor.cleanUpMockHistory();
    }
}
