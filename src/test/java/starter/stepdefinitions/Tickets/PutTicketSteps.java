package starter.stepdefinitions.Tickets;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.Tickets.PostTickets;
import starter.Tickets.PutTickets;

public class PutTicketSteps {
    @Steps
    PutTickets putTickets;

    //Successful Update Detail Tickets with Existent ID
    @Given("I set API endpoint to update tickets available")
    public void setAPIForUpdateTicketAvailable() {
        putTickets.setAPIForUpdateTicketAvailable();
    }
    @When("I send a request PUT request to update tickets with valid ID")
    public void sendPUTRequestUpdateTicketWithValidID() {
        putTickets.sendPUTRequestUpdateTicketWithValidID();
    }
    @Then("The response should contain of the updated detail tickets")
    public void receiveValidDataForUpdateTicketWithValidID() {
        putTickets.receiveValidDataForUpdateTicketWithValidID();
    }

    //Successful Update Tickets Quantity
    @When("I send a request PUT request to quantity tickets")
    public void sendPUTRequestUpdateTicketWithQuantityTickets() {
        putTickets.sendPUTRequestUpdateTicketWithQuantityTickets();
    }
    @Then("The response should contain of the updated event with the changed quantity tickets")
    public void receiveValidDataForUpdateTicketWithQuantityTicket() {
        putTickets.receiveValidDataForUpdateTicketWithQuantityTicket();
    }

    //Successful Update Tickets Due Date
    @When("I send a request PUT request to date tickets")
    public void sendPUTRequestUpdateTicketWithDateTickets() {
        putTickets.sendPUTRequestUpdateTicketWithDateTickets();
    }
    @Then("The response should contain of the updated event with the changed date tickets")
    public void receiveValidDataForUpdateTicketWithDateTicket() {
        putTickets.receiveValidDataForUpdateTicketWithDateTicket();
    }

    //Can not update tickets with invalid or non-existent ID
    @Given("I set API endpoint for update a tickets with invalid ID")
    public void setAPIForUpdateTicketWithInvalidID() {
        putTickets.setAPIForUpdateTicketWithInvalidID();
    }
    @When("I send a request PUT to update tickets invalid ID")
    public void sendPUTRequestUpdateTicketWithInvalidID() {
        putTickets.sendPUTRequestUpdateTicketWithInvalidID();
    }
    @Then("I should receive an error message indicating that the tickets was not found")
    public void receiveMessageErrorInvalidIDUpdateTicket() {
        putTickets.receiveMessageErrorInvalidIDUpdateTicket();
    }


    // Can not update tickets with invalid endpoint API
    @Given("I set invalid API endpoint tickets for update tickets")
    public void setInvalidAPIForUpdateTicket() {
        putTickets.setInvalidAPIForUpdateTicket();
    }
    @When("I send a request PUT request with invalid endpoint")
    public void sendPUTRequestUpdateTicketWithInvalidEndpoint() {
        putTickets.sendPUTRequestUpdateTicketWithInvalidEndpoint();
    } @When("I should receive a status code of 404 for update ticket")
    public void receiveStatusCode404ForUpdateTicket() {
        putTickets.receiveStatusCode404ForUpdateTicket();
    }
    @Then("I should receive an error message indicating that not found")
    public void receiveMessageErrorThatNotFound() {
        putTickets.receiveMessageErrorThatNotFound();
    }

}
