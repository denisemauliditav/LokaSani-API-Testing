package starter.stepdefinitions.Product;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.Product.GetProductByID;

public class GetProductByIDSteps {
    @Steps
    GetProductByID getProductByID;

    @Given("I set API endpoint for get a product by ID")
    public void setAPIForGetProductByID(){
        getProductByID.setAPIForGetProductByID();
    }
    @When("I send a request to get the product with the valid ID")
    public void sendGetRequestForGetProductByID(){
        getProductByID.sendGetRequestForGetProductByID();
    }
    @Then("I should receive a status code of 200 for get a product by ID")
    public void receiveStatusShouldEqualCode200ForGetProductByID(){
        getProductByID.receiveStatusShouldEqualCode200ForGetProductByID();
    }
    @And("I should receive the details of the product associated with the provided ID")
    public void receiveDetailGetProduct(){
        getProductByID.receiveDetailGetProduct();
    }


    //case negative
    @Given("I set API endpoint for get a product with invalid ID")
    public void setInvalidAPIToGetProductByID(){
        getProductByID.setInvalidAPIToGetProductByID();
    }
    @When("I send a request GET to get product invalid id")
    public void sendRequestGETInvalidID(){
        getProductByID.sendRequestGETInvalidID();
    }
    @And("I should receive an error message indicating that the product was not found")
    public void receiveMessageErrorShouldIndicatePageNotFound(){
        getProductByID.receiveMessageErrorShouldIndicatePageNotFound();
    }
}
