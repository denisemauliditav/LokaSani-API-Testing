package starter.stepdefinitions.Event;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.Event.GetEvents;
import starter.Event.PutEvents;

public class PutEventSteps {
    @Steps
    PutEvents putEvents;
    //Successful Update Name Event Information
    @Given("I set API endpoint for update event")
    public void setAPIForUpdateEvent() {
        putEvents.setAPIForUpdateEvent();
    }
    @When("I send a request PUT request to update name information")
    public void sendPUTRequestEventWithNameInformation() {
        putEvents.sendPUTRequestEventWithNameInformation();
    }
    @And("I should receive a 200 OK response")
    public void receiveStatusShouldEqualCode200ForUpdateEvent() {
        putEvents.receiveStatusShouldEqualCode200ForUpdateEvent();
    }
    @Then("The response should contain of the updated event with the changed event name")
    public void receiveValidDataForUpdateEventWithNameInformation() {
        putEvents.receiveValidDataForUpdateEventWithNameInformation();
    }



//Successful Update Description Event Information
    @When("I send a request PUT request to update a description")
    public void sendPUTRequestEventWithDescriptionInformation() {
        putEvents.sendPUTRequestEventWithDescriptionInformation();
    }
    @Then("The response should contain of the updated event with the changed event description")
    public void receiveValidDataForUpdateEventWithDescriptionInformatpm() {
        putEvents.receiveValidDataForUpdateEventWithDescriptionInformatpm();
    }

    //Successful Update Date Event Information
    @When("I send a request PUT request to update a date")
    public void sendPUTRequestEventWithDateInformation() {
        putEvents.sendPUTRequestEventWithDateInformation();
    }
    @Then("The response should contain of the updated event with the changed event date")
    public void receiveValidDataForUpdateEventWithDateInformation() {
        putEvents.receiveValidDataForUpdateEventWithDateInformation();
    }

    //Updated Event with Invalid Event ID
    @Given("I set API endpoint for update event with invalid event ID")
    public void setAPIForUpdateEventWithInvalidID() {
        putEvents.setAPIForUpdateEventWithInvalidID();
    }
    @When("I send a request PUT request to update a date with invalid event ID")
    public void sendPUTRequestEventWithInvalidID() {
        putEvents.sendPUTRequestEventWithInvalidID();
    }
    @And("I should receive a 500 code")
    public void receiveStatusShouldEqualCode500ForUpdateEvent() {
        putEvents.receiveStatusShouldEqualCode500ForUpdateEvent();
    }
    @Then("The response should contain an error message indicating that the event ID is not found")
    public void responseShouldContainErrorMessageIDIsNotFound() {
        putEvents.responseShouldContainErrorMessageIDIsNotFound();
    }


    //Updated Event with Invalid URL
    @Given("I set invalid endpoint API for update event with invalid event URL")
    public void setAPIForUpdateEventWithInvalidURL() {
        putEvents.setAPIForUpdateEventWithInvalidURL();
    }
    @When("I send a request PUT request to update a date with invalid event URL")
    public void sendPUTRequestEventWithInvalidURL() {
        putEvents.sendPUTRequestEventWithInvalidURL();
    }
    @And("I should receive a 404 code for update event with invalid url")
    public void receiveStatusShouldEqualCode404ForUpdateEvent() {
        putEvents.receiveStatusShouldEqualCode404ForUpdateEvent();
    }
    @Then("The response should contain an error message indicating that not found")
    public void responseShouldContainErrorMessageIsNotFoundForEvents() {
        putEvents.responseShouldContainErrorMessageIsNotFoundForEvents();
    }

}
