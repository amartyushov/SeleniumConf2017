package io.mart.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.mart.util.KeyValueHolder;
import io.swagger.client.model.User;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class UserSteps extends AbstractSteps {

    @Given("^create user with params$")
    public void createUserWithParams(List<KeyValueHolder> params) throws Throwable {
        User user = userProvider.buildUser(new User(), params);
        resultHolder.storeResult(userExecutor.createUser(user));
    }

    @Then("^user has name \"([^\"]*)\"$")
    public void userHasName(String name) throws Throwable {
        userChecker.userHasName((User) resultHolder.getResult(), name);
    }

    @And("^do nothing$")
    public void doNothing() throws Throwable {
        log.info("Step implementation");
    }
}
