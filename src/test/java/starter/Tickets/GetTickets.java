package starter.Tickets;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.GenerateToken;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class GetTickets {
    private static String url = "https://lokasani.my.id/";

    //Get All Tickets Successfully
    @Step("I set API endpoint for get all tickets is available")
    public String setApiEndpointGetAllTickets() {
        return url + "ticket";
    }

    @Step("I send a request GET to get all events")
    public void sendGetAllTicket() {
        SerenityRest.given().get(setApiEndpointGetAllTickets());
        //generate token
        String data = GenerateToken.generateToken();

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + data)
                .get(setApiEndpointGetAllTickets());
    }
    @Step("I should receive a status code of 200 for get ticket")
    public void responseStatusCode200ForGetTicket(){
        restAssuredThat(response-> response.statusCode(200));
    }

    @Step("The API should respond with a list of tickets")
    public void shouldRespondWithAllistLocalArtTickets() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_ALL_TICKET_SCHEMA);
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    //Get Tickets by Valid ID
    @Step("I set API endpoint to get tickets by valid ID")
    public String setApiEndpointGetTicketByID() {
        return url + "ticket/3";
    }

    @Step("I send a request GET to get tickets by valid ID")
    public void sendGetTicketByID() {
        SerenityRest.given().get(setApiEndpointGetTicketByID());
        //generate token
        String data = GenerateToken.generateToken();

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + data)
                .get(setApiEndpointGetTicketByID());
    }

    @Step("The API should respond with a list of tickets to get tickets by valid ID")
    public void shouldRespondWithTicketByID() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_TICKET_BY_ID_SCHEMA);
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }


    //Get Tickets based on VIP Tickets
    // (untuk schema masih belum fix karna masih muncul data yang bukan vip)
    @Step("I set API endpoint to get tickets based on VIP")
    public String setApiEndpointGetTicketBasedOnVIP() {
        return url + "/ticket?type=VIP";
    }

    @Step("I send a request GET to get tickets based on VIP")
    public void sendGetTicketBasedOnVIP() {
        SerenityRest.given().get(setApiEndpointGetTicketBasedOnVIP());
        //generate token
        String data = GenerateToken.generateToken();

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + data)
                .get(setApiEndpointGetTicketBasedOnVIP());
    }

    @Step("The API should respond with a list of tickets to get tickets based on VIP")
    public void shouldRespondWithTicketBasedOnVIP() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_ALL_TICKET_SCHEMA);
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    //Get Tickets based on Reguler Tickets
    // (untuk schema masih belum fix karna masih muncul data yang bukan reguler)
    @Step("I set API endpoint to get tickets based on Reguler")
    public String setApiEndpointGetTicketBasedOnReguler() {
        return url + "/ticket?type=REGULER";
    }

    @Step("I send a request GET to get tickets based on Reguler")
    public void sendGetTicketBasedOnREGULER() {
        SerenityRest.given().get(setApiEndpointGetTicketBasedOnReguler());
        //generate token
        String data = GenerateToken.generateToken();

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + data)
                .get(setApiEndpointGetTicketBasedOnReguler());
    }
    @Step("The API should respond with a list of tickets to get tickets based on Reguler")
    public void shouldRespondWithTicketBasedOnReguler() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_ALL_TICKET_SCHEMA);
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    // Can not get tickets with invalid or non-existent ID
    @Step("I set API endpoint for get a tickets with invalid ID")
    public String setApiEndpointGetTicketWithInvalidID() {
        return url + "ticket/78";
    }
    @Step("I send a request GET to get tickets invalid ID")
    public void sendGetTicketWithInvalidID() {
        SerenityRest.given().get(setApiEndpointGetTicketWithInvalidID());
        //generate token
        String data = GenerateToken.generateToken();

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + data)
                .get(setApiEndpointGetTicketWithInvalidID());
    }

    // Can not get tickets with invalid endpoint API
    @Step("I set invalid API endpoint for get tickets")
    public String setInvalidApiEndpointForGetTicket() {
        return url + "tickets/";
    }
    @Step("I send a request GET request with invalid endpoint")
    public void sendGetTicketWithInvalidEndpointAPI() {
        SerenityRest.given().get(setInvalidApiEndpointForGetTicket());
        //generate token
        String data = GenerateToken.generateToken();

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + data)
                .get(setInvalidApiEndpointForGetTicket());
    }

}
