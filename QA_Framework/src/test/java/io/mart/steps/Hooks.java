package io.mart.steps;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.spi.LoggingEvent;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class Hooks extends AbstractSteps {

    @Before("@deleteAll")
    public void deleteAll() {
        log.info("Executing @deleteAll hook");
        userExecutor.deleteUsers();
    }

    @Before(order = -10)
    public void firstOfAll(Scenario scenario) {
        log.info("starting scenario \"{}\" at {}",scenario.getName(), Calendar.getInstance().getTime());
        scenarioContextContainer.init();
    }

    @After(order = -10)
    public void lastOfAll(Scenario scenario) {
        if (scenario.isFailed()) {
            recordInternalLogs(scenario);
        }
        scenarioContextContainer.reset();
        log.info("scenario \"{}\" completed with status {}", scenario.getName(), scenario.getStatus());
    }

    private void recordInternalLogs(Scenario scenario) {
        List<LoggingEvent> accumulatedLogs = scenarioContextContainer.getAccumulatedLogs();
        scenario.write("internal logs:");
        List<String> collect = accumulatedLogs.stream().map(ILoggingEvent::getFormattedMessage).collect(Collectors.toList());
        scenario.write(StringUtils.join(collect, "\n"));
    }
}
