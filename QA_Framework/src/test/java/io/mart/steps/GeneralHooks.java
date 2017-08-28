package io.mart.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GeneralHooks extends AbstractSteps{

    @Before("@general_hook_first")
    public void generalHook_first(){
        GeneralHookExecutor.runBasedOnFlag("flag1", this::generalHook_1);
    }

    @Before("@general_hook_second")
    public void generalHook_second(){
        GeneralHookExecutor.runBasedOnFlag("flag2", this::generalHook_2);
    }

    private void generalHook_1(){
        log.info("GENERAL. Execution of first hook");
    }

    private void generalHook_2(){
        log.info("GENERAL. Execution of second hook");
    }

    @After("@data_changed")
    public void dataChanged(){
        GeneralHookExecutor.updateHookFlagValue("anyValueToReset");
    }
}
