package starter.stepdefinitions.SuperAdmin;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.SuperAdmin.Register;

public class RegisterSteps {

    @Steps
    Register register;

    @Given("I set API endpoint for register")
    public void setApiEndpoint() {
        register.setApiEndpoint();
    }

    @When("I send request to register")
    public void sendRegisterRequest() {
        register.sendRegisterRequest();
    }

    @Then("I receive status code 200")
    public void sendRegisterRequest200() {
        register.sendRegisterRequest200();
    }

    @And("I receive valid data for register")
    public void receiveValidRegisterData() {
        register.receiveValidRegisterData();
    }

    ////CASE NEGATIVE
    @When("I send request register with existing data")
    public void sendRegisterRequestWithExistingData() {
        register.sendRegisterRequestWithExistingData();
    }

    @Then("I receive status code 400")
    public void sendRegisterRequest400() {
        register.sendRegisterRequest400();
    }

    @And("I receive message error for register")
    public void receiveMessageErrorForRegister() {
        register.receiveMessageErrorForRegister();
    }
}
