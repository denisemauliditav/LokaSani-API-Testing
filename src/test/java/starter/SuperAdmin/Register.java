package starter.SuperAdmin;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;
import starter.utils.FileUtils;
import starter.utils.JsonSchemaHelper;
import starter.utils.JsonSchema;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;

public class Register {
    private static String url = "https://lokasani.my.id/";

    @Step("I set API endpoint for register")
    public String setApiEndpoint() {
        return url + "admin/register";
    }

    @Step("I send request to register")
    public void sendRegisterRequest() {
        JSONObject requestBody = FileUtils.getUser();

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post(setApiEndpoint());
    }

    @Step("I receive status code 200")
    public void sendRegisterRequest200() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("I receive valid data for register")
    public void receiveValidRegisterData() {
        restAssuredThat(response -> response.body("'id'", nullValue()));
        restAssuredThat(response -> response.body("'token'", nullValue()));

    }
    ///case negative

//    @Step("I send request register with existing data")
    public void sendRegisterRequestWithExistingData() {
        JSONObject requestBody = FileUtils.getUser();

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post(setApiEndpoint());
    }
    @Step("I receive status code 400")
    public void sendRegisterRequest400() {
        restAssuredThat(response -> response.statusCode(500));
    }
    @Step("I receive message error for register")
    public void receiveMessageErrorForRegister() {
            System.out.println("failed to register new user to database");
    }
}
