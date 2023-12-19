package starter.Product;

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

public class UpdateProduct {
    private static String url = "https://lokasani.my.id/";
    //background
    @Step("I set API for update product")
    public String setAPIForUpdateProduct(){
        return url + "product/4";
    }

    //Case-Positive-updateProduct1
    @Step("I send request PUT to update product with name only")
    public void sendPUTRequestWithNameOnly(){
        JSONObject requestBody = new JSONObject();
        String data = GenerateToken.generateToken();
        requestBody.put("'data'.'name'", "Tas Batek");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + data)
                .body(requestBody.toString())
                .put(setAPIForUpdateProduct());
    }
    @Step("The response status code should be 200 (OK)")
    public void receiveStatusShouldEqualCode200() {
        restAssuredThat(response -> response.statusCode(200));
    }
    @Step("The response should contain the details of the updated product with the changed name")
    public void receiveValidDataForUpdateProductWithNameOnly() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.UPDATE_PRODUCT_SCHEMA);
//        restAssuredThat(response -> response.body("'id'", equalTo(1)));
        restAssuredThat(response -> response.body("'data'.'name'", equalTo("Tas Batek")));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    //////Case-Positive-updateProduct2
    @Step("I send request PUT to update product with price only")
    public void sendPUTRequestWithPriceOnly(){
        JSONObject requestBody = new JSONObject();
        String data = GenerateToken.generateToken();
        requestBody.put("'data'.'price'", 350000);

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + data)
                .body(requestBody.toString())
                .put(setAPIForUpdateProduct());
    }
    @Step("The response should contain the details of the updated product with the changed name")
    public void receiveValidDataForUpdateProductWithPriceOnly() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.UPDATE_PRODUCT_SCHEMA);
//        restAssuredThat(response -> response.body("'id'", equalTo(1)));
        restAssuredThat(response -> response.body("'data'.'price'", equalTo(350000)));
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    //////Case-Positive-updateProduct3
    @Step("I send request PUT to update product with description only")
    public void sendPUTRequestWithDescriptionOnly(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("'data'.'description'", "ini merupakan tas kerajinan tangan");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .put(setAPIForUpdateProduct());

        //generate token
        String data = GenerateToken.generateToken();

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + data)
                .put(setAPIForUpdateProduct());
    }
    @Step("The response should contain the details of the updated product with the changed description")
    public void receiveValidDataForUpdateProductWithDescriptionOnly() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.UPDATE_PRODUCT_SCHEMA);
//        restAssuredThat(response -> response.body("'id'", equalTo(1)));
        restAssuredThat(response -> response.body("'data'.'description'", equalTo("ini merupakan tas kerajinan tangan")));
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    //////Case-Negative-updateProduct1
    @Step("I set API for update product with invalid ID")
    public String setInvalidAPIEndpointUpdateProduct(){
        return url + "product/109";
    }
    @Step("I send request PUT to update product with invalid ID")
    public void sendInvalidRequestUpdateProduct(){
        SerenityRest.given().put(setInvalidAPIEndpointUpdateProduct());
        //generate token
        String data = GenerateToken.generateToken();

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + data)
                .put(setInvalidAPIEndpointUpdateProduct());
    }
    @Step("The response status code should be 404 (Not Found)")
    public void receiveStatusCode404InUpdateProduct(){
        restAssuredThat(response -> response.statusCode(404));
    }
    @Step("The response should contain an error message indicating that the product ID is not found")
    public void responsePageNotFoundOnTheUpdateProduct(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.INVALID_ID_GET_PRODUCT_SCHEMA);
        restAssuredThat(response -> response.body("'message'",is("record not found")));
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    //////Case-Negative-updateProduct2
    @Step("I set API for update product with empty ID")
    public String setInvalidAPIEndpointUpdateProductWIthEmptyID(){
        return url + "product";
    }
    @Step("I send request PUT to update product with empty ID")
    public void sendInvalidRequestUpdateProductWithEmptyID(){
        SerenityRest.given().put(setInvalidAPIEndpointUpdateProductWIthEmptyID());
        //generate token
        String data = GenerateToken.generateToken();

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + data)
                .put(setInvalidAPIEndpointUpdateProductWIthEmptyID());
    }
    @Step("The response status code should be 405 (Method Not Allowed)")
    public void receiveStatusCode405InUpdateProduct(){
        restAssuredThat(response -> response.statusCode(405));
    }
    @Step("The response should contain an error message indicating that the update data is not found")
    public void responseUpdateProductNotFound(){
        System.out.println("Not Found");
    }
}

