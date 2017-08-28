package io.mart.mock;

import org.springframework.stereotype.Component;

@Component
public class SchemaLoader {

    public String getPath(String schemaName){
        return "schemas/"+schemaName;
    }
}
