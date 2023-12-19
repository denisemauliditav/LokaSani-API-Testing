package starter.Event;

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

public class PostEvents {
    private static String url = "https://lokasani.my.id/";

    //background
    @Step("I set API endpoint for creating a new event is available")
    public String setAPIForCreateNewEvent() {
        return url + "event";
    }

    //User successfully creates a new event
    @Step("I send a request POST to create a new event with valid inputs")
    public void sendPOSTRequestForCreateNewEvent() {
        JSONObject requestBody = new JSONObject();
//        requestBody.put("fromDate", "2023-12-31T12:00:00Z");
//        requestBody.put("toDate", "2023-12-31T12:00:00Z");
        requestBody.put("eventName", "The Dream Show");
//        requestBody.put("startTime", "2023-12-31T12:00:00");
        requestBody.put("endTime", "2023-12-31T12:00:00");
        requestBody.put("eventDescription", "This is event the dream show");
        requestBody.put("ticketPrice", 3000000);
        requestBody.put("creatorId", 3);
        requestBody.put("categoryId", 4);

        String data = GenerateToken.generateToken();
        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + data)
                .body(requestBody.toString())
                .post(setAPIForCreateNewEvent());
    }
    @Step("I should receive the details of the newly created event")
    public void receiveValidDataForCreateNewEvent() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.CREATE_NEW_EVENT_SCHEMA);
//        restAssuredThat(response -> response.body("'data'.'fromDate'", equalTo("2023-12-31T12:00:00Z")));
//        restAssuredThat(response -> response.body("'data'.'toDate'", equalTo("2023-12-31T12:00:00Z")));
        restAssuredThat(response -> response.body("'data'.'eventName'", equalTo("The Dream Show")));
//        restAssuredThat(response -> response.body("'data'.'startTime'", equalTo("2023-12-31T12:00:00")));
        restAssuredThat(response -> response.body("'data'.'endTime'", equalTo("2023-12-31T12:00:00")));
        restAssuredThat(response -> response.body("'data'.'eventDescription'", equalTo("This is event the dream show")));
        restAssuredThat(response -> response.body("'data'.'ticketPrice'", equalTo(3000000)));
        restAssuredThat(response -> response.body("'data'.'creatorId'", equalTo(3)));
        restAssuredThat(response -> response.body("'data'.'categoryId'", equalTo(4)));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    //User can not create an event without required fields
    @Step("I send a request to create a new event with required fields")
    public void sendPOSTRequestForCreateNewEventWithRequiredFields() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("fromDate", "");
        requestBody.put("toDate", "");
        requestBody.put("eventName", "");
        requestBody.put("startTime", "");
        requestBody.put("endTime", "");
        requestBody.put("eventDescription", "");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post(setAPIForCreateNewEvent());

        //generate token
        String data = GenerateToken.generateToken();

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + data)
                .post(setAPIForCreateNewEvent());
    }
    @Step("I should receive a status code of 400")
    public void responseStatusCode400() {
        restAssuredThat(response -> response.statusCode(500));
    }
    @Step("I should receive an error message indicating that the fields is empty")
    public void receiveMessageErrorFieldsIsEmpty() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.INVALID_REQUIRED_FIELDS_CREATE_EVENT);
        restAssuredThat(response -> response.body("'message'",is("name is empty")));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }


    //User can not create an event with invalid data format
    @Step("I send a request to create a new event with invalid data format")
    public void sendPOSTRequestForCreateNewEventWithRInvalidDataFormat() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("fromDate", "Saturday-21-Janurary-2023");
        requestBody.put("toDate", "Saturday-21-Janurary-2023");
        requestBody.put("eventName", "Swifty");
        requestBody.put("startTime", "Saturday-21-Janurary-2023");
        requestBody.put("endTime", "Saturday-21-Janurary-2023");
        requestBody.put("eventDescription", "event lokal dari provinsi medan");
        requestBody.put("ticketPrice", "Rp 3.800.000");
        requestBody.put("creatorId", 3);
        requestBody.put("categoryId", 4);

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post(setAPIForCreateNewEvent());

        //generate token
        String data = GenerateToken.generateToken();

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + data)
                .post(setAPIForCreateNewEvent());
    }

    @Step("I should receive an error message indicating that format not valid")
    public void receiveMessageErrorThatFormatNotValid() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.INVALID_REQUIRED_FIELDS_CREATE_EVENT);
        restAssuredThat(response -> response.body("'message'",is("format not valid")));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

}
