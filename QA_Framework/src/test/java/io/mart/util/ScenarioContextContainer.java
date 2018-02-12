package io.mart.util;

import ch.qos.logback.classic.spi.ILoggingEvent;
import cucumber.api.Scenario;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ScenarioContextContainer {
    private static boolean insideOfFeature;
    private static List<ILoggingEvent> accumulatedLogs = new ArrayList<>();

    public void init() {
        insideOfFeature = true;
    }

    public void reset() {
        insideOfFeature = false;
        accumulatedLogs.clear();
    }

    public List<ILoggingEvent> getAccumulatedLogs() {
        return accumulatedLogs;
    }

    public static void addLogEntry(ILoggingEvent event) {
        if (insideOfFeature) {
            accumulatedLogs.add(event);
        }
    }
}
   
