package io.mart.checker;

import jersey.repackaged.com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.fluent.Request;
import org.junit.ComparisonFailure;
import org.junit.runner.notification.RunNotifier;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

@Component
@Slf4j
public class HealthChecker {

    public void checkMicroserviceStatuses(RunNotifier notifier) {

        // In logs it is better to see particular thread name
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("health_check")
                .build();

        ScheduledExecutorService scheduler = Executors
                .newSingleThreadScheduledExecutor(namedThreadFactory);

        Runnable task = () -> {
            getServiceLinks().stream()
                    .forEach(sLink -> {
                        checkStatusForParticularService(sLink, notifier);
                    });
        };
        scheduler.scheduleAtFixedRate(task, 0, 3000, TimeUnit.MILLISECONDS);
    }

    private void checkStatusForParticularService(String healthLink, RunNotifier notifier) {
        log.info("Checking health status, {}", healthLink);
        try {
            String s = Request.Get(healthLink)
                    .execute().returnContent().asString();
            assertThat(s).contains("UP");
            log.info(s);
        } catch (IOException e) {
            log.error("Connection to Health service refused");
            notifier.pleaseStop();
            // => when next test starts exception StoppedByUserException() will be thrown
            // end test execution stops (see org.junit.runner.notification.RunNotifier.fireTestStarted())
        } catch (ComparisonFailure e) {
            log.error("Health status is not UP");
            notifier.pleaseStop();
        }
    }

    /**
     * 1. In general case number of services is more than one (but for current example it is enough)
     * 2. This is just an abstraction over how you get links to your microservices
     *
     * @return
     */
    private List<String> getServiceLinks() {
        return Arrays.asList("http://localhost:8080/health");
    }
}
