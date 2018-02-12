package io.mart.util;

import ch.qos.logback.classic.spi.LoggingEvent;
import ch.qos.logback.core.Appender;
import ch.qos.logback.core.Context;
import ch.qos.logback.core.LogbackException;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.ContextAware;
import ch.qos.logback.core.spi.FilterReply;
import ch.qos.logback.core.status.Status;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ScenarioAppender implements ContextAware, Appender<LoggingEvent>{

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void doAppend(LoggingEvent loggingEvent) throws LogbackException {
        ScenarioContextContainer.addLogEntry(loggingEvent);
    }

    @Override
    public void setName(String s) {

    }

    @Override
    public void setContext(Context context) {

    }

    @Override
    public Context getContext() {
        return null;
    }

    @Override
    public void addStatus(Status status) {

    }

    @Override
    public void addInfo(String s) {

    }

    @Override
    public void addInfo(String s, Throwable throwable) {

    }

    @Override
    public void addWarn(String s) {

    }

    @Override
    public void addWarn(String s, Throwable throwable) {

    }

    @Override
    public void addError(String s) {

    }

    @Override
    public void addError(String s, Throwable throwable) {

    }

    @Override
    public void addFilter(Filter<LoggingEvent> filter) {

    }

    @Override
    public void clearAllFilters() {

    }

    @Override
    public List<Filter<LoggingEvent>> getCopyOfAttachedFiltersList() {
        return null;
    }

    @Override
    public FilterReply getFilterChainDecision(LoggingEvent loggingEvent) {
        return null;
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public boolean isStarted() {
        return false;
    }
}
