package starter.stepdefinitions.Event;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.Event.PostEvents;
import starter.Event.PutEvents;

public class PostEventSteps {
    @Steps
    PostEvents postEvents;

    //User successfully creates a new event
    @Given("I set API endpoint for creating a new event is available")
    public void setAPIForCreateNewEvent() {
        postEvents.setAPIForCreateNewEvent();
    }
    @When("I send a request POST to create a new event with valid inputs")
    public void sendPOSTRequestForCreateNewEvent() {
        postEvents.sendPOSTRequestForCreateNewEvent();
    } @And("I should receive a status code of 400")
    public void responseStatusCode400() {
        postEvents.responseStatusCode400();
    }
    @Then("I should receive the details of the newly created event")
    public void receiveValidDataForCreateNewEvent() {
        postEvents.receiveValidDataForCreateNewEvent();
    }


    //User can not create an event without required fields
    @When("I send a request to create a new event with required fields")
    public void sendPOSTRequestForCreateNewEventWithRequiredFields() {
        postEvents.sendPOSTRequestForCreateNewEventWithRequiredFields();
    }
    @Then("I should receive an error message indicating that the fields is empty")
    public void receiveMessageErrorFieldsIsEmpty() {
        postEvents.receiveMessageErrorFieldsIsEmpty();
    }


    //User can not create an event with invalid data format
    @When("I send a request to create a new event with invalid data format")
    public void sendPOSTRequestForCreateNewEventWithRInvalidDataFormat() {
        postEvents.sendPOSTRequestForCreateNewEventWithRInvalidDataFormat();
    }
    @Then("I should receive an error message indicating that format not valid")
    public void receiveMessageErrorThatFormatNotValid() {
        postEvents.receiveMessageErrorThatFormatNotValid();
    }
}
