package io.mart.util;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class TagsHolder {

    private Set<String> tags = new HashSet<>();

    public void setTags(Set<String> tags){
        this.tags = tags;
    }

    public Set<String> getTags() {
        return tags;
    }
}
