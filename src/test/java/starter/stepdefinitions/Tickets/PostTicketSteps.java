package starter.stepdefinitions.Tickets;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.Tickets.PostTickets;

public class PostTicketSteps {
    @Steps
    PostTickets postTickets;

    //Successfully create a new ticket with valid inputs
    @Given("I set API endpoint for creating a new ticket is available")
    public void setAPIForCreateNewTicket() {
        postTickets.setAPIForCreateNewTicket();
    }
    @When("I send a request POST to create a new ticket with valid inputs")
    public void sendPOSTRequestForCreateNewTicket() {
        postTickets.sendPOSTRequestForCreateNewTicket();
    }
    @Then("I should receive the details of the newly created ticket")
    public void receiveValidDataForCreateNewTicket() {
        postTickets.receiveValidDataForCreateNewTicket();
    }


    //Can not create new ticket with missing required fields
    @When("I send a request POST to create a new ticket with missing required fields")
    public void sendPOSTRequestForCreateNewTicketWithMissingRequiredFields() {
        postTickets.sendPOSTRequestForCreateNewTicketWithMissingRequiredFields();
    }
    @And("I should receive a status code of 400 for missing required fields")
    public void receiveStatusCode400ForMissingRequiredFields() {
        postTickets.receiveStatusCode400ForMissingRequiredFields();
    }   @Then("I should receive message error from missing required fields")
    public void receiveMessageErrorMissingFieldsCreateTicket() {
        postTickets.receiveMessageErrorMissingFieldsCreateTicket();
    }


    //Can not create new ticket with negative quantity
    @When("I send a request POST to create a new ticket with negative quantity")
    public void sendPOSTRequestForCreateNewTicketWithNegativeQuantity() {
        postTickets.sendPOSTRequestForCreateNewTicketWithNegativeQuantity();
    }
    @And("I should receive a status code of 400 for negative quantity")
    public void receiveStatusCode400ForNegativeQuantity() {
        postTickets.receiveStatusCode400ForNegativeQuantity();
    }@Then("I should receive message error from negative quantity")
    public void receiveMessageErrorMissingFieldsCreateTicketFromNegativeQuantity() {
        postTickets.receiveMessageErrorMissingFieldsCreateTicketFromNegativeQuantity();
    }

}
