package io.mart.executors;

import io.mart.util.TagsHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@Slf4j
public class CleanUpExecutor {

    @Autowired
    private TagsHolder tagsHolder;

    public void deleteAll(){
        Set<String> tags = tagsHolder.getTags();
        log.info("tags {}", tags);

        for(String tag : tags){
            switch (tag){
                case ("@api"):
                    log.info("cleaning api");
                    break;
                case ("@bm"):
                    log.info("cleaning bm");
                    break;
            }
            // add runnable to set to avoid duplication execution of runnables
        }
    }
}
