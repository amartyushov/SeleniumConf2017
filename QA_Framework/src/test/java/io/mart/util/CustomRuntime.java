package io.mart.util;

import cucumber.runtime.ClassFinder;
import cucumber.runtime.Runtime;
import cucumber.runtime.RuntimeOptions;
import cucumber.runtime.io.ResourceLoader;
import gherkin.formatter.Reporter;
import gherkin.formatter.model.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Component
public class CustomRuntime extends Runtime {

    @Autowired
    private TagsHolder tagsHolder;

    public CustomRuntime(ResourceLoader resourceLoader, ClassFinder classFinder, ClassLoader classLoader, RuntimeOptions runtimeOptions) {
        super(resourceLoader, classFinder, classLoader, runtimeOptions);
    }

    @Override
    public void runBeforeHooks(Reporter reporter, Set<Tag> tags) {
        tagsHolder.setTags(tags.stream()
                .map(Tag::getName)
                .collect(Collectors.toSet()));
        super.runBeforeHooks(reporter, tags);
    }
}
