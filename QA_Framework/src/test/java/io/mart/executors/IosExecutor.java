package io.mart.executors;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component("IOS")
@Slf4j
public class IosExecutor implements IExecutor {

    @Override
    public void startApplication() {
        log.info("Starting IOS application");
    }

    @Override
    public void inputLogin() {
        log.info("Input login to IOS app");
    }

    @Override
    public void inputPassword() {
        log.info("Input password to IOS app");
    }
}
