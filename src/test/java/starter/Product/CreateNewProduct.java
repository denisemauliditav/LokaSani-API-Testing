package starter.Product;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;
import starter.utils.GenerateToken;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class CreateNewProduct {
    private static String url = "https://lokasani.my.id/";

    //background
    @Step("I set API endpoint for creating a new product is available")
    public String setAPIForCreateNewProduct() {
        return url + "product";
    }

    //CreateNewDataProduct-Positive
    @Step("I send a request POST to create a new product with valid inputs")
    public void sendPOSTRequestForCreateNewProduct() {
        JSONObject requestBody = new JSONObject();
        String data = GenerateToken.generateToken();
//        requestBody.put("'data'.'id'", 17);

        requestBody.put("name", "Kain Batik Anyaman");
        requestBody.put("price", 250000);
        requestBody.put("description", "kain batik");
        requestBody.put("status", "active");
        requestBody.put("categoryId", 2);
        requestBody.put("creatorId", 3);

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + data)
                .body(requestBody.toString())
                .post(setAPIForCreateNewProduct());

    }

    @Step("I should receive the details of the newly created product")
    public void receiveValidDataForCreateNewProduct() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.CREATE_NEW_PRODUCT_SCHEMA);
//        restAssuredThat(response -> response.body("'id'", equalTo(17)));
        restAssuredThat(response -> response.body("'data'.'name'", equalTo("Kain Batik Anyaman")));
        restAssuredThat(response -> response.body("'data'.'price'", equalTo(250000)));
        restAssuredThat(response -> response.body("'data'.'description'", equalTo("kain batik")));
        restAssuredThat(response -> response.body("'data'.'status'", equalTo("active")));
        restAssuredThat(response -> response.body("'data'.'categoryId'", equalTo(2)));
        restAssuredThat(response -> response.body("'data'.'creatorId'", equalTo(3)));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    /// @CreateNewDataProduct-Negative
    @Step("I send a request to create a new product with duplicate fields")
    public void sendDuplicatePOSTRequestForCreateNewProduct() {
        JSONObject requestBody = new JSONObject();
        String data = GenerateToken.generateToken();
        requestBody.put("'data'.'name'", "Tas Kerajinan Tangan");
        requestBody.put("'data'.'price'", 250000);
        requestBody.put("'data'.'description'", "Tas batik");
        requestBody.put("'data'.'status'", "active");
        requestBody.put("'data'.'categoryId'", 2);
        requestBody.put("'data'.'creatorId'", 3);

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + data)
                .body(requestBody.toString())
                .post(setAPIForCreateNewProduct());
    }

    @Step("I should receive a status code of 500")
    public void responseStatusCode500ForCreateNewProduct(){
        restAssuredThat(response-> response.statusCode(500));
    }
    @Step("I should receive an error message error in create new data product")
    public void receiveMessageErrorDuplicateFields() {
        System.out.println("duplicate fields");
    }
}
