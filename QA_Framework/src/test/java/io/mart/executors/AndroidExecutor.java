package io.mart.executors;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component("ANDROID")
@Slf4j
public class AndroidExecutor implements IExecutor {

    @Override
    public void startApplication() {
        log.info("Starting ANDROID application");
    }

    @Override
    public void inputLogin() {
        log.info("Input login to ANDROID app");
    }

    @Override
    public void inputPassword() {
        log.info("Input password to ANDROID app");
    }
}
