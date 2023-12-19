package starter.stepdefinitions.Creator;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.Creator.LoginCreator;
import starter.SuperAdmin.Login;

public class LoginCreatorSteps {
    @Steps
    LoginCreator loginCreator;

    @Given("I set API endpoint for login creator")
    public void setApiEndpointLoginCreator() {
        loginCreator.setApiEndpointLoginCreator();
    }

    @When("I send request to login creator with valid email {string} and valid password {string}")
    public void sendLoginCreatorRequest(String email, String password) {
        loginCreator.sendLoginCreatorRequest(email, password);
    }

    @And("I receive valid data for login creator")
    public void receiveValidDataForLoginCreator() {
        loginCreator.receiveValidDataForLoginCreator();
    }

}
