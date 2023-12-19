package starter.Creator;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;

public class LoginCreator {
    private static String url = "https://lokasani.my.id/";

    @Step("I set API endpoint for login creator")
    public String setApiEndpointLoginCreator() {
        return url + "admin/login";
    }

    @Step("I send request to login creator with valid email {string} and valid password {string}")
    public void sendLoginCreatorRequest(String email, String password) {
        JSONObject requestBody = new JSONObject();

        requestBody.put("email", email);
        requestBody.put("password", password);

        SerenityRest.given()
                .header("Content-Type","application/json")
                .body(requestBody.toString())
                .post(setApiEndpointLoginCreator());
    }

    @Step("I receive valid data for login creator")
    public void receiveValidDataForLoginCreator() {
        restAssuredThat(response -> response.body("'data'", notNullValue()));

    }
}
