package starter.Product;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.is;

public class GetProductByID{
    private static String url = "https://lokasani.my.id/";
    @Step("I set API endpoint for get a product by ID")
    public String setAPIForGetProductByID() {
        return url + "product/4";
    }
    @Step("I send a request to get the product with the valid ID")
    public void sendGetRequestForGetProductByID() {
        SerenityRest.given().get(setAPIForGetProductByID());
    }
    @Step("I should receive a status code of 200 for get a product by ID")
    public void receiveStatusShouldEqualCode200ForGetProductByID() {
        restAssuredThat(response -> response.statusCode(200));
    }
   @Step("I should receive the details of the product associated with the provided ID")
    public void receiveDetailGetProduct() {
       JsonSchemaHelper helper = new JsonSchemaHelper();
       String schema = helper.getResponseSchema(JsonSchema.GET_PRODUCT_BY_ID_SCHEMA);

       restAssuredThat(response->response.body(matchesJsonSchema(schema)));
    }


    //case negative
    @Step("I set API endpoint for get a product with invalid ID")
    public String setInvalidAPIToGetProductByID() {
        return url + "product/5050";
    }
    @Step("I send a request GET to get product invalid id")
    public void sendRequestGETInvalidID() {
        SerenityRest.given().get(setInvalidAPIToGetProductByID());
    }
    @Step("I should receive an error message indicating that the product was not found")
    public void receiveMessageErrorShouldIndicatePageNotFound() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.INVALID_ID_GET_PRODUCT_SCHEMA);
        restAssuredThat(response -> response.body("'message'",is("record not found")));
        restAssuredThat(response->response.body(matchesJsonSchema(schema)));
    }
}
