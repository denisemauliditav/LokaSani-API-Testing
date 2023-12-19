package starter.SuperAdmin;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;
import starter.utils.GenerateToken;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;

public class Login {
    private static String url = "https://lokasani.my.id/";

    @Step("I set API endpoint for login")
    public String setApiEndpoint() {
        return url + "admin/login";
    }

    @Step("I send request to login with valid email {string} and valid password {string}")
    public void sendLoginRequest(String email, String password) {
        JSONObject requestBody = new JSONObject();

        requestBody.put("email", email);
        requestBody.put("password", password);

        SerenityRest.given()
                .header("Content-Type","application/json")
                .body(requestBody.toString())
                .post(setApiEndpoint());
    }


    @Step("I receive valid data for login")
    public void receiveValidDataForLogin() {
        restAssuredThat(response -> response.body("'data'", notNullValue()));

    }

    @Step("I receive status code 404")
    public void receiveStatusCode404() {
        restAssuredThat(response -> response.statusCode(404));
    }
    @Step("I send request to login with unregistered email {string} and valid password {string}")
    public void sendLoginRequestWithUnregisteredCredentials(String email, String password) {
        JSONObject requestBody = new JSONObject();

        requestBody.put("email", email);
        requestBody.put("password", password);

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post(setApiEndpoint());
    }

    @Step("I receive message error")
    public void receiveMessageError() {
        System.out.println("email not found");
    }
}