package starter.stepdefinitions.SuperAdmin;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.SuperAdmin.Login;

public class LoginSteps {

    @Steps
    Login login;

    @Given("I set API endpoint for login")
    public void setApiEndpoint() {
        login.setApiEndpoint();
    }

    @When("I send request to login with valid email {string} and valid password {string}")
    public void sendLoginRequest(String email, String password) {
        login.sendLoginRequest(email, password);
    }

    @And("I receive valid data for login")
    public void receiveValidDataForLogin() {
        login.receiveValidDataForLogin();
    }

    ///NEGATIVE CASE
    @When("I send request to login with unregistered email {string} and valid password {string}")
    public void sendLoginRequestWithUnregisteredCredentials(String email, String password) {
        login.sendLoginRequestWithUnregisteredCredentials(email, password);
    }

    @When("I receive status code 404")
    public void receiveStatusCode404() {
        login.receiveStatusCode404();
    }
    @When("I receive message error")
    public void receiveMessageError() {
        login.receiveMessageError();
    }
}
