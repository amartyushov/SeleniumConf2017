package io.mart.steps;

import io.mart.checker.UserChecker;
import io.mart.executors.IExecutor;
import io.mart.executors.UserCreationExecutor;
import io.mart.providers.UserProvider;
import io.mart.util.ResultHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class AbstractSteps {

    @Autowired
    public UserProvider userProvider;

    @Autowired
    public UserCreationExecutor userExecutor;

    @Autowired
    public UserChecker userChecker;

    @Autowired
    public ResultHolder resultHolder;

    @Autowired
    @Qualifier("app")
    public IExecutor executor;

}
