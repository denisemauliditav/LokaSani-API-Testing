package starter.stepdefinitions.Tickets;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.Tickets.GetTickets;


public class GetTicketSteps {
    @Steps
    GetTickets getTickets;

    //Get All Tickets Successfully
    @Given("I set API endpoint for get all tickets is available")
    public void setApiEndpointGetAllTickets() {
        getTickets.setApiEndpointGetAllTickets();
    }
    @When("I send a request GET to get all tickets")
    public void sendGetAllTicket() {
        getTickets.sendGetAllTicket();
    }
    @And("I should receive a status code of 200 for get ticket")
    public void responseStatusCode200ForGetTicket() {
        getTickets.responseStatusCode200ForGetTicket();
    }
    @Then("The API should respond with a list of tickets")
    public void shouldRespondWithAllistLocalArtTickets() {
        getTickets.shouldRespondWithAllistLocalArtTickets();
    }

    //Get Tickets by Valid ID
    @Given("I set API endpoint to get tickets by valid ID")
    public void setApiEndpointGetTicketByID() {
        getTickets.setApiEndpointGetTicketByID();
    }
    @When("I send a request GET to get tickets by valid ID")
    public void sendGetTicketByID() {
        getTickets.sendGetTicketByID();
    }
    @Then("The API should respond with a list of tickets to get tickets by valid ID")
    public void shouldRespondWithTicketByID() {
        getTickets.shouldRespondWithTicketByID();
    }

//    //Get Tickets based on VIP Tickets
//    @Given("I set API endpoint to get tickets based on VIP")
//    public void setApiEndpointGetTicketBasedOnVIP() {
//        getTickets.setApiEndpointGetTicketBasedOnVIP();
//    }
//    @When("I send a request GET to get tickets based on VIP")
//    public void sendGetTicketBasedOnVIP() {
//        getTickets.sendGetTicketBasedOnVIP();
//    }
//    @Then("The API should respond with a list of tickets to get tickets based on VIP")
//    public void shouldRespondWithTicketBasedOnVIP() {
//        getTickets.shouldRespondWithTicketBasedOnVIP();
//    }
//
//    //Get Tickets based on Reguler Tickets
//    @Given("I set API endpoint to get tickets based on Reguler")
//    public void setApiEndpointGetTicketBasedOnReguler() {
//        getTickets.setApiEndpointGetTicketBasedOnReguler();
//    }
//    @When("I send a request GET to get tickets based on Reguler")
//    public void sendGetTicketBasedOnREGULER() {
//        getTickets.sendGetTicketBasedOnREGULER();
//    }
//    @Then("The API should respond with a list of tickets to get tickets based on Reguler")
//    public void shouldRespondWithTicketBasedOnReguler() {
//        getTickets.shouldRespondWithTicketBasedOnReguler();
//    }

    //Can not get tickets with invalid or non-existent ID
    @Given("I set API endpoint for get a tickets with invalid ID")
    public void setApiEndpointGetTicketWithInvalidID() {
        getTickets.setApiEndpointGetTicketWithInvalidID();
    }
    @When("I send a request GET to get tickets invalid ID")
    public void sendGetTicketWithInvalidID() {
        getTickets.sendGetTicketWithInvalidID();
    }

    // Can not get tickets with invalid endpoint API
    @Given("I set invalid API endpoint for get tickets")
    public void setInvalidApiEndpointForGetTicket() {
        getTickets.setInvalidApiEndpointForGetTicket();
    }
    @When("I send a request GET request with invalid endpoint")
    public void sendGetTicketWithInvalidEndpointAPI() {
        getTickets.sendGetTicketWithInvalidEndpointAPI();
    }


}
