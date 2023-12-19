package starter.utils;

import io.restassured.response.ResponseBody;
import net.serenitybdd.rest.SerenityRest;
import org.json.JSONObject;

public class GenerateToken {
    public static String generateToken() {
        JSONObject userData = FileUtils.getUser();
        JSONObject requestBody = new JSONObject();

        requestBody.put("email", userData.get("email"));
        requestBody.put("password", userData.get("password"));

        ResponseBody loginResponse = SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post("https://lokasani.my.id/admin/login")
                .body();

        JSONObject loginResponseBody = new JSONObject(loginResponse.asString());

        JSONObject responseData = loginResponseBody.getJSONObject("data");

        return responseData.get("token").toString();
    }
}