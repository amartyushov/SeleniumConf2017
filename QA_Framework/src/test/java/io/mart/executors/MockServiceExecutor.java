package io.mart.executors;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.fluent.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Slf4j
@Component
public class MockServiceExecutor {

    @Autowired
    private ObjectMapper mapper;

    public void cleanUpMockHistory() throws IOException {
        log.info("EXECUTOR Cleaning up history of mock calls");
        Request.Delete("http://localhost:8090/cleanHistory").execute();
    }

    public List<String> getRecentCalls() throws IOException {
        log.info("EXECUTOR Receiving history of mock calls");
        return mapper.readValue(
                Request.Get("http://localhost:8090/calls")
                        .execute()
                        .returnContent()
                        .asString(),
                List.class);
    }
}
