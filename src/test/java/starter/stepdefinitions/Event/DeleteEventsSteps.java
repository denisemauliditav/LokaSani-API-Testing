package starter.stepdefinitions.Event;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.Event.DeleteEvents;
import starter.Event.GetEvents;

public class DeleteEventsSteps {
    @Steps
    DeleteEvents deleteEvents;

    //As a user I can delete event with valid ID
    @Given("I set API endpoint for delete event By valid ID")
    public void setAPIForDeleteEventByValidID() {
        deleteEvents.setAPIForDeleteEventByValidID();
    }
    @When("I send a request to delete the event with the valid ID")
    public void sendDeleteRequestForEventByValidID() {
        deleteEvents.sendDeleteRequestForEventByValidID();
    }


    // As a user I can not delete a event with invalid or non-existent ID
    @Given("I set API endpoint for delete event By invalid ID")
    public void setAPIForEventByInvalidID() {
        deleteEvents.setAPIForDeleteEventByValidID();
    }
    @When("I send a request to delete the event with the invalid ID")
    public void sendDeleteRequestEventWithInvalidID() {
        deleteEvents.sendDeleteRequestEventWithInvalidID();
    }



}
