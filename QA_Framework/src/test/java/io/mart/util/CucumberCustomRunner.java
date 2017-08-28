package io.mart.util;

import cucumber.api.junit.Cucumber;
import io.mart.mock.SmartMock;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.InitializationError;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

public class CucumberCustomRunner extends Cucumber {

    public CucumberCustomRunner(Class clazz) throws InitializationError, IOException {
        super(clazz);
    }

    @Override
    public void run(RunNotifier notifier) {
        SmartMock.startMock();
        super.run(notifier);
    }
}
