package io.mart.mock;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.MatcherAssert.assertThat;

@Component
@Slf4j
public class SchemaChecker {

    @Autowired
    private SchemaLoader schemaLoader;

    public boolean verifySchema(String request, String schemaName) {
        try {
            assertThat(request, matchesJsonSchemaInClasspath(schemaLoader.getPath(schemaName)));
            log.info("[MOCK] Request {} passed validation for schema {}", request, schemaName);
            return true;
        } catch (AssertionError e) {
            log.info("[MOCK] Request {} did not match schema: {}", request, schemaName);
            log.info(e.getMessage());
            return false;
        }
    }
}
