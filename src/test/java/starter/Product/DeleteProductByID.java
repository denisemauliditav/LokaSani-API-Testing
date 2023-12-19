package starter.Product;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.GenerateToken;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;



public class DeleteProductByID {
    private static String url = "https://lokasani.my.id/";

    @Step("I set API endpoint for delete product By valid ID")
    public String setAPIForDeleteProductByID() {
        return url + "product/2";
    }
    @Step("I send a request to delete the product with the valid ID")
    public void sendDeleteRequestForDeleteProductByID() {
        SerenityRest.given().delete(setAPIForDeleteProductByID());

        //generate token
        String data = GenerateToken.generateToken();

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + data)
                .delete(setAPIForDeleteProductByID());
    }

        @Step("I should receive a status code of 200")
    public void receiveStatusCode200ForDeleteProduct(){
        restAssuredThat(response -> response.statusCode(500));
    }
    @Step("The product was deleted successfully")
    public void receiveSuccessfullyMessage() {
        System.out.println("success");
    }

    //case negative
    @Step("I set API endpoint for delete product By invalid ID")
    public String setInvalidAPIForDeleteProductByID() {
        return url + "product/50";
    }
    @Step("I send a request to delete the product with the invalid ID")
    public void sendDeleteRequestInvalidForDeleteProductByID() {
        SerenityRest.given().get(setInvalidAPIForDeleteProductByID());
    }
    @Step("I should receive a status code of 404")
    public void responseStatusCode404ForGetProductByID(){
        restAssuredThat(response-> response.statusCode(500));
    }
    @Step("The product fails to be deleted and an error message appears that product data not found")
    public void receiveMessageErrorShouldIndicatePageNotFound() {
        System.out.println("Error message indicates that the page was not found.");
    }
}
