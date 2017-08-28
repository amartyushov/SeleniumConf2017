package io.mart.steps;

import cucumber.api.java.Before;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Hooks extends AbstractSteps{

    private static boolean init = false;
    private static boolean secondInit = false;

    @Before("@deleteAll")
    public void deleteAll(){
        log.info("Executing @deleteAll hook");
        userExecutor.deleteUsers();
    }

    @Before("@first_setup")
    public void firstSetup(){
        if (!init) {
            init = true;
            log.info("Execution of hook: first_setup");
        }
    }

    @Before("@second_setup")
    public void secondSetup(){
        if (!secondInit) {
            secondInit = true;
            log.info("Execution of hook: second_setup");
        }
    }
}
