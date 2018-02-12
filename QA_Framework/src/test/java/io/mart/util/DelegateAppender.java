package io.mart.util;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.ext.spring.DelegatingLogbackAppender;
import org.springframework.stereotype.Component;

/**
 * https://github.com/qos-ch/logback-extensions/wiki/Spring
 *
 * Thread safe
 * Filtering
 */
@Component
public class DelegateAppender extends DelegatingLogbackAppender {

    @Override
    protected void append(ILoggingEvent event) {
        ScenarioContextContainer.addLogEntry(event);
        super.append(event);
    }
}
