package io.mart.mock;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
@Slf4j
public class SmartMock {

    @Autowired
    private SchemaChecker schemaChecker;

    private volatile List<String> invocations = new ArrayList<>();

    /**
     * Service which we want to mock
     * @param o
     * @return
     */
    @RequestMapping(path = "/notify", method = RequestMethod.POST)
    @ResponseBody
    String withDedicatedPath(@RequestBody Object o) {
        String deserialised = deserialize(o);
        log.info("Request is caught by mock service");
        if(schemaChecker.verifySchema(deserialised, "user.json")){
            // any custom operation can be performed now (e.g. invocation of Google Cloud Messaging)
            invocations.add(deserialised);
        }
        return deserialised;
    }

    /**
     * Util service for cucumber to receive mock service operation information
     * @return
     */
    @RequestMapping(path = "/calls", method = RequestMethod.GET)
    @ResponseBody
    List<String> getAllCalls() {
        log.info("Returning all stored calls of mock service, {}", invocations);
        return invocations;
    }

    /**
     * Util service for cucumber to clean up mock service history between tests
     * @return
     */
    @RequestMapping(path = "/cleanHistory", method = RequestMethod.DELETE)
    @ResponseBody
    String cleanCallHistory() {
        log.info("Cleaning up mock service history");
        invocations = new ArrayList<>();
        return "Mock service history was cleaned";
    }

    private String deserialize(Object o) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
        }
        return null;
    }

    public static void startMock(){
        SpringApplication.run(SmartMock.class);
    }

}
