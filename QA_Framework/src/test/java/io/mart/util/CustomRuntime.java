package io.mart.util;

import cucumber.runtime.ClassFinder;
import cucumber.runtime.Runtime;
import cucumber.runtime.RuntimeOptions;
import cucumber.runtime.io.ResourceLoader;
import gherkin.formatter.Reporter;
import gherkin.formatter.model.Tag;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
public class CustomRuntime extends Runtime {

    @Autowired
    private TagsHolder tagsHolder;

    // constructor will be  called during initialisation of this
    public static CustomRuntime customRuntime;

    public CustomRuntime(ResourceLoader resourceLoader, ClassFinder classFinder, ClassLoader classLoader, RuntimeOptions runtimeOptions) {
        super(resourceLoader, classFinder, classLoader, runtimeOptions);
        customRuntime = this;
    }

    public static CustomRuntime getInstance(){
        return customRuntime;
    }

    @Override
    public void runBeforeHooks(Reporter reporter, Set<Tag> tags) {
        tagsHolder.setTags(tags.stream()
                .map(Tag::getName)
                .collect(Collectors.toSet()));
        super.runBeforeHooks(reporter, tags);
    }
}
