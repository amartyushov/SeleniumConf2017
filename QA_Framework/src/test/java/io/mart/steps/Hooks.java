package io.mart.steps;

import cucumber.api.java.Before;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Hooks extends AbstractSteps{

    @Before("@deleteAll")
    public void deleteAll(){
        cleanUpExecutor.deleteAll();
        log.info("Executing @deleteAll hook");
        userExecutor.deleteUsers();
    }

    @Before("@hook")
    public void hook(){
        cleanUpExecutor.deleteAll();
        log.info("Do test data preparation");
    }


}
