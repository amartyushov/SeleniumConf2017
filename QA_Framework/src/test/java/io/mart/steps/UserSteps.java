package io.mart.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.mart.util.KeyValueHolder;
import io.swagger.client.model.User;

import java.util.List;

public class UserSteps extends AbstractSteps {

    @Given("^create user with params$")
    public void createUserWithParams(List<KeyValueHolder> params) throws Throwable {
        User user = userProvider.buildUser(userProvider.defaultUser(), params);
        resultHolder.storeResult(userExecutor.createUser(user));
    }

    @Then("^user has name \"([^\"]*)\"$")
    public void userHasName(String name) throws Throwable {
        userChecker.userHasName((User) resultHolder.getResult(), name);
    }

    @And("^wait for (\\d+) seconds$")
    public void waitForSeconds(int seconds) throws Throwable {
        Thread.sleep(seconds * 1000);
    }

    @And("^send push notification to user \"([^\"]*)\"$")
    public void sendPushNotificationToUserAlex(String name) throws Throwable {
        User user = userExecutor.getUserByName(name);
        userExecutor.sendingPushNotification(user);
    }

    @And("^Mock was called to notify user \"([^\"]*)\"$")
    public void mockWasCalledToNotifyUser(String name) throws Throwable {
        List<String> recentCalls = mockServiceExecutor.getRecentCalls();
        userChecker.pushWasSentToUser(recentCalls, name);
    }
}
