package starter.Tickets;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;
import starter.utils.GenerateToken;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.equalTo;

public class PutTickets {
    private static String url = "https://lokasani.my.id/";
    @Step("I set API endpoint to update tickets available")
    public String setAPIForUpdateTicketAvailable(){
        return url + "ticket/3";
    }

    //Successful Update Detail Tickets with Existent ID
    @Step("I send a request PUT request to update tickets with valid ID")
    public void sendPUTRequestUpdateTicketWithValidID(){
        JSONObject requestBody = new JSONObject();
        String data = GenerateToken.generateToken();

        requestBody.put("'data'.'type'", "Regular");
        requestBody.put("'data'.'price'", 300000);
        requestBody.put("'data'.'qty'", 500);
        requestBody.put("'data'.'name'", "Noah");
        requestBody.put("'data'.'description'", "this is band noah");
        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + data)
                .body(requestBody.toString())
                .put(setAPIForUpdateTicketAvailable());
    }
    @Step("The response should contain of the updated detail tickets")
    public void receiveValidDataForUpdateTicketWithValidID() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.UPDATE_TICKET_SCHEMA);
        restAssuredThat(response -> response.body("'data'.'type'", equalTo("Regular")));
        restAssuredThat(response -> response.body("'data'.'price'", equalTo(300000)));
        restAssuredThat(response -> response.body("'data'.'qty'", equalTo(500)));
        restAssuredThat(response -> response.body("'data'.'name'", equalTo("Noah")));
        restAssuredThat(response -> response.body("'data'.'description'", equalTo("this is band noah")));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }


    //Successful Update Tickets Quantity
    @Step("I send a request PUT request to quantity tickets")
    public void sendPUTRequestUpdateTicketWithQuantityTickets(){
        JSONObject requestBody = new JSONObject();
        String data = GenerateToken.generateToken();
        requestBody.put("'data'.'qty'", 500);
        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + data)
                .body(requestBody.toString())
                .put(setAPIForUpdateTicketAvailable());

    }
    @Step("The response should contain of the updated event with the changed quantity tickets")
    public void receiveValidDataForUpdateTicketWithQuantityTicket() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.UPDATE_TICKET_SCHEMA);
        restAssuredThat(response -> response.body("'data'.'qty'", equalTo(500)));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }


    //Successful Update Tickets Due Date
    @Step("I send a request PUT request to date tickets")
    public void sendPUTRequestUpdateTicketWithDateTickets(){
        JSONObject requestBody = new JSONObject();
        String data = GenerateToken.generateToken();
        requestBody.put("'data'.'startTime'", "0001-01-01T00:00:00ZZ");
        requestBody.put("'data'.'endTime'", "0001-01-01T00:00:00Z");
        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + data)
                .body(requestBody.toString())
                .put(setAPIForUpdateTicketAvailable());
        //generate token
//        String data = GenerateToken.generateToken();
//
//        SerenityRest.given()
//                .header("Content-Type", "application/json")
//                .header("Authorization", "Bearer " + data)
//                .put(setAPIForUpdateTicketAvailable());
    }
    @Step("The response should contain of the updated event with the changed date tickets")
    public void receiveValidDataForUpdateTicketWithDateTicket() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.UPDATE_TICKET_SCHEMA);
        restAssuredThat(response -> response.body("'data'.'startTime'", equalTo("0001-01-01T00:00:00Z")));
        restAssuredThat(response -> response.body("'data'.'endTime'", equalTo("0001-01-01T00:00:00Z")));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    //Can not update tickets with invalid or non-existent ID
    @Step("I set API endpoint for update a tickets with invalid ID")
    public String setAPIForUpdateTicketWithInvalidID(){
        return url + "ticket/200";
    }
    @Step("I send a request PUT to update tickets invalid ID")
    public void sendPUTRequestUpdateTicketWithInvalidID(){
        SerenityRest.given().put(setAPIForUpdateTicketWithInvalidID());
        //generate token
        String data = GenerateToken.generateToken();

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + data)
                .put(setAPIForUpdateTicketWithInvalidID());
    }
    @Step("I should receive an error message indicating that the tickets was not found")
    public void receiveMessageErrorInvalidIDUpdateTicket() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.MESSAGE_ERROR_UPDATE_TICKET_SCHEMA);
        restAssuredThat(response -> response.body("'message'",is("record not found")));
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }


    //Can not update tickets with invalid endpoint API
    @Step("I set invalid API endpoint tickets for update tickets")
    public String setInvalidAPIForUpdateTicket(){
        return url + "ticketsd/200";
    }
    @Step("I send a request PUT request with invalid endpoint")
    public void sendPUTRequestUpdateTicketWithInvalidEndpoint(){
        SerenityRest.given().put(setInvalidAPIForUpdateTicket());
        //generate token
        String data = GenerateToken.generateToken();

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + data)
                .put(setInvalidAPIForUpdateTicket());
    }
    @Step("I should receive a status code of 404 for update ticket")
    public void receiveStatusCode404ForUpdateTicket() {
        restAssuredThat(response -> response.statusCode(404));
    }
    @Step("I should receive an error message indicating that not found")
    public void receiveMessageErrorThatNotFound() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.INVALID_ENDPOINT_UPDATE_TICKET_SCHEMA);
        restAssuredThat(response -> response.body("'message'",is("Not Found")));
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
