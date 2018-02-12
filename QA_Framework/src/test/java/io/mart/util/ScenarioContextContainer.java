package io.mart.util;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.spi.LoggingEvent;
import cucumber.api.Scenario;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ScenarioContextContainer {
    private static boolean insideOfFeature;
    private static List<LoggingEvent> accumulatedLogs = new ArrayList<>();

    public void init() {
        insideOfFeature = true;
    }

    public void reset() {
        insideOfFeature = false;
        accumulatedLogs.clear();
    }

    public List<LoggingEvent> getAccumulatedLogs() {
        return accumulatedLogs;
    }

    public static void addLogEntry(LoggingEvent event) {
        if (insideOfFeature) {
            accumulatedLogs.add(event);
        }
    }
}
