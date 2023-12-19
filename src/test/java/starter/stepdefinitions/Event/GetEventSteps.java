package starter.stepdefinitions.Event;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.Event.GetEvents;

public class GetEventSteps {
    @Steps
    GetEvents getEvents;

    //get all events
    @Given("I set API endpoint for get all events is available")
    public void setInvalidEndpointForGetDetailvents() {
        getEvents.setInvalidEndpointForGetDetailvents();
    }
    @When("I send a request GET to get all events")
    public void sendGetAllEvent() {
        getEvents.sendGetAllEvent();
    }

    @And("I should receive a status code of 200 for get all events")
    public void responseStatusCode200ForGetAllEvent() {
        getEvents.responseStatusCode200ForGetAllEvent();
    }
    @Then("The API should respond with a list of local art culture events")
    public void shouldRespondWithAllistLocalArtEvents() {
        getEvents.shouldRespondWithAllistLocalArtEvents();
    }

  //get detail events by id
    @Given("I set API endpoint for get detail events is available")
    public void setApiEndpointGetAllEvents() {
        getEvents.setApiEndpointGetAllEvents();
    }
    @When("I send a request GET to get detail events")
    public void sendRequestGETToGetDetailEvents() {
        getEvents.sendRequestGETToGetDetailEvents();
    }@And("I should receive a status code of 200 for get detail events by ID")
    public void responseStatusCode200ForGetEventByID() {
        getEvents.responseStatusCode200ForGetEventByID();
    }
    @Then("The API should respond with detailed information about the event")
    public void shouldRespondWithDetailedInformationAboutTheEvent() {
        getEvents.shouldRespondWithDetailedInformationAboutTheEvent();
    }

//    //invalid request get all events
//    @Given("I set API invalid endpoint for get all events")
//    public void setInvalidApiEndpointGetAllEvents() {
//        getEvents.setInvalidApiEndpointGetAllEvents();
//    }
//    @When("I send a request GET to get invalid request all events")
//    public void sendInvalidGetAllEvent() {
//        getEvents.sendInvalidGetAllEvent();
//    }
//    @And("I should receive a status code of 400")
//    public void responseStatusCode400() {
//        getEvents.responseStatusCode400();
//    }
//    @Then("The response body should contain an error message")
//    public void shouldResponseBodyErrorMessage() {
//        getEvents.shouldResponseBodyErrorMessage();
//    }


    //Can not get detail event with invalid or non-existent ID
    @Given("I set API endpoint for get detail event with invalid ID")
    public void setAPIEndpointWithInvalidIDGetDetailEvent() {
        getEvents.setAPIEndpointWithInvalidIDGetDetailEvent();
    }
    @When("I send a request GET to get detail event with invalid ID")
    public void sendInvalidIDGetDetailEvent() {
        getEvents.sendInvalidIDGetDetailEvent();
    }
    @And("I should receive a status code of 404 for invalid ID")
    public void responseStatusCode404ForNonExistentID() {
        getEvents.responseStatusCode404ForNonExistentID();
    }
    @Then("The response body should contain an error message not found")
    public void shouldResponseBodyErrorMessageNotFound() {
        getEvents.shouldResponseBodyErrorMessageNotFound();
    }
}
