package io.mart.util;

import cucumber.api.junit.Cucumber;
import io.mart.checker.HealthChecker;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.InitializationError;

import java.io.IOException;

@Slf4j
public class CucumberCustomRunner extends Cucumber {

    public CucumberCustomRunner(Class clazz) throws InitializationError, IOException {
        super(clazz);
    }

    @Override
    public void run(RunNotifier notifier) {
        new HealthChecker().checkMicroserviceStatuses(notifier);
        super.run(notifier);
    }

    public static void main(String[] args) {
    }
}
