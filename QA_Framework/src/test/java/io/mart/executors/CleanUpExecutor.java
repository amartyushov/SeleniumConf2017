package io.mart.executors;

import io.mart.util.TagsHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@Slf4j
public class CleanUpExecutor {

    @Autowired
    private TagsHolder tagsHolder;

    private Runnable cleanMySql = () -> log.info("Cleaning up MySql");
    private Runnable cleanRedis = () -> log.info("Cleaning up Redis");
    private Runnable cleanCassandra = () -> log.info("Cleaning up Cassandra");
    private Runnable cleanElastic = () -> log.info("Cleaning up Elastic");

    private Set<Runnable> toExecute = new HashSet<>();

    public void deleteAll() {
        Set<String> tags = tagsHolder.getTags(); // to avoid duplicates
        log.info("tags {}", tags);

        for (String tag : tags) {
            switch (tag) {
                case ("@api"):
                    toExecute.add(cleanCassandra);
                    toExecute.add(cleanMySql);
                    toExecute.add(cleanRedis);
                    break;
                case ("@bm"):
                    toExecute.add(cleanRedis);
                    toExecute.add(cleanElastic);
                    break;
            }
        }
        toExecute.forEach(p -> {
            try {
                p.run();
            } catch (Throwable e) {
                log.error("unable to execute cleaning action " + p, e);
                System.exit(1);
            }
        });
        toExecute.clear();
    }
}
