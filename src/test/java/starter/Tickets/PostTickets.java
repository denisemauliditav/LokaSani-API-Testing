package starter.Tickets;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;
import starter.utils.GenerateToken;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class PostTickets {
    private static String url = "https://lokasani.my.id/";

    //background
    @Step("I set API endpoint for creating a new ticket is available")
    public String setAPIForCreateNewTicket() {
        return url + "ticket";
    }

    //Successfully create a new ticket with valid inputs
    @Step("I send a request POST to create a new ticket with valid inputs")
    public void sendPOSTRequestForCreateNewTicket() {
        String data = GenerateToken.generateToken();
        JSONObject requestBody = new JSONObject();
        requestBody.put("type", "REGULER");
        requestBody.put("price", 50000);
        requestBody.put("qty", 500);
        requestBody.put("name", "JKT48");
        requestBody.put("description", "konser jkt48");
        requestBody.put("startTime", "0001-01-01T00:00:00Z");
        requestBody.put("endTime", "0001-01-01T00:00:00Z");
        requestBody.put("eventId", 2);

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + data)
                .body(requestBody.toString())
                .post(setAPIForCreateNewTicket());

    }
    @Step("I should receive the details of the newly created ticket")
    public void receiveValidDataForCreateNewTicket() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.CREATE_NEW_TICKET_SCHEMA);
        restAssuredThat(response -> response.body("'data'.'type'", equalTo("REGULER")));
        restAssuredThat(response -> response.body("'data'.'price'", equalTo(50000)));
        restAssuredThat(response -> response.body("'data'.'qty'", equalTo(500)));
        restAssuredThat(response -> response.body("'data'.'name'", equalTo("JKT48")));
        restAssuredThat(response -> response.body("'data'.'description'", equalTo("konser jkt48")));
        restAssuredThat(response -> response.body("'data'.'startTime'", equalTo("0001-01-01T00:00:00Z")));
        restAssuredThat(response -> response.body("'data'.'endTime'", equalTo("0001-01-01T00:00:00Z")));
        restAssuredThat(response -> response.body("'data'.'eventId'", equalTo(2)));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }




//Can not create new ticket with missing required fields(date)
    @Step("I send a request POST to create a new ticket with missing required fields")
    public void sendPOSTRequestForCreateNewTicketWithMissingRequiredFields() {
        JSONObject requestBody = new JSONObject();
        String data = GenerateToken.generateToken();

        requestBody.put("type", "REGULER");
        requestBody.put("price", 50000);
        requestBody.put("qty", 500);
        requestBody.put("name", "JKT48");
        requestBody.put("description", "konser jkt48");
        requestBody.put("startTime", "");
        requestBody.put("endTime", "");
        requestBody.put("eventId", 2);

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + data)
                .body(requestBody.toString())
                .post(setAPIForCreateNewTicket());

    }
    @Step("I should receive a status code of 400 for missing required fields")
    public void receiveStatusCode400ForMissingRequiredFields() {
        restAssuredThat(response -> response.statusCode(400));
    }
    @Step("I should receive message error from missing required fields")
    public void receiveMessageErrorMissingFieldsCreateTicket() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.MESSAGE_ERROR_CREATE_TICKET_SCHEMA);
        restAssuredThat(response -> response.body("'data'.'type'", equalTo("")));
        restAssuredThat(response -> response.body("'data'.'price'", equalTo(50000)));
        restAssuredThat(response -> response.body("'data'.'qty'", equalTo(500)));
        restAssuredThat(response -> response.body("'data'.'name'", equalTo("JKT48")));
        restAssuredThat(response -> response.body("'data'.'description'", equalTo("konser jkt48")));
        restAssuredThat(response -> response.body("'data'.'startTime'", equalTo("")));
        restAssuredThat(response -> response.body("'data'.'endTime'", equalTo("")));
        restAssuredThat(response -> response.body("'data'.'eventId'", equalTo(2)));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }


// Can not create new ticket with negative quantity
    @Step("I send a request POST to create a new ticket with negative quantity")
    public void sendPOSTRequestForCreateNewTicketWithNegativeQuantity() {
        JSONObject requestBody = new JSONObject();
        String data = GenerateToken.generateToken();

        requestBody.put("type", "REGULER");
        requestBody.put("price", -50000);
        requestBody.put("qty", 500);
        requestBody.put("name", "JKT48");
        requestBody.put("description", "konser jkt48");
        requestBody.put("startTime", "");
        requestBody.put("endTime", "");
        requestBody.put("eventId", 2);

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + data)
                .body(requestBody.toString())
                .post(setAPIForCreateNewTicket());

    }
    @Step("I should receive a status code of 400 for negative quantity")
    public void receiveStatusCode400ForNegativeQuantity() {
        restAssuredThat(response -> response.statusCode(400));
    }
    @Step("I should receive message error from negative quantity")
    public void receiveMessageErrorMissingFieldsCreateTicketFromNegativeQuantity() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.MESSAGE_ERROR_CREATE_TICKET_SCHEMA);
        restAssuredThat(response -> response.body("'data'.'type'", equalTo("")));
        restAssuredThat(response -> response.body("'data'.'price'", equalTo(50000)));
        restAssuredThat(response -> response.body("'data'.'qty'", equalTo(500)));
        restAssuredThat(response -> response.body("'data'.'name'", equalTo("JKT48")));
        restAssuredThat(response -> response.body("'data'.'description'", equalTo("konser jkt48")));
        restAssuredThat(response -> response.body("'data'.'startTime'", equalTo("")));
        restAssuredThat(response -> response.body("'data'.'endTime'", equalTo("")));
        restAssuredThat(response -> response.body("'data'.'eventId'", equalTo(2)));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }


}
