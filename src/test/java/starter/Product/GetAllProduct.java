package starter.Product;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.GenerateToken;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.is;

public class GetAllProduct {
    private static String url = "http://lokasani.my.id";
    @Step("I set API endpoint for get all product")
    public String setApiEndpointGetAllProduct() {
        return url + "/product";
    }
    @Step("I send GET request to the endpoint to get all products")
    public void sendGetAllProduct() {
        String data = GenerateToken.generateToken();
        SerenityRest.given()
                .header("Authorization", "Bearer " + data)
                .header("Content-Type", "application/json")
                .get(setApiEndpointGetAllProduct());
    }
    @Step("the response status code should be 200")
    public void responseStatusCode200(){
        restAssuredThat(response-> response.statusCode(200));
    }
    @Step("I receive valid data for get all products")
    public void receiveValidDataForGetAllProducts(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_ALL_PRODUCT_SCHEMA);

        restAssuredThat(response->response.body(matchesJsonSchema(schema)));
    }


    // As a admin I can not get products with invalid parameters
    @Step("I set invalid API endpoint for get all product with invalid parameters")
    public String setInvalidApiEndpointGetAllProduct() {
        return url + "/products";
    }
    @Step("I send GET request for get all product")
    public void sendGetRequestGetAllProduct() {
        SerenityRest.given().get(setInvalidApiEndpointGetAllProduct());

        String data = GenerateToken.generateToken();

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + data)
                .get(setInvalidApiEndpointGetAllProduct());
    }
    @Step("The response status code equal 404")
    public void responseStatusCode404(){
        restAssuredThat(response-> response.statusCode(404));
    }
    @Step("I receive error message")
    public void receiveErrorMessage(){
        restAssuredThat(response -> response.body("'message'",is("Not Found")));
    }
}