package starter.stepdefinitions.Product;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.Product.GetAllProduct;

public class GetAllProductSteps {
    @Steps
    GetAllProduct getAllProduct;

    @Given("I set API endpoint for get all product")
    public void setApiEndpointGetAllProduct(){
        getAllProduct.setApiEndpointGetAllProduct();
    }
    @When("I send GET request to the endpoint to get all products")
    public void sendGetAllUsersRequest(){
        getAllProduct.sendGetAllProduct();
    }
    @Then("the response status code should be 200")
    public void responseStatusCode200(){
        getAllProduct.responseStatusCode200();
    }
    @And("I receive valid data for get all products")
    public void receiveValidDataForGetAllProducts(){
        getAllProduct.receiveValidDataForGetAllProducts();
    }

    @Given("I set invalid API endpoint for get all product with invalid parameters")
    public void setInvalidApiEndpointGetAllProduct(){
        getAllProduct.setInvalidApiEndpointGetAllProduct();
    }
    @When("I send GET request for get all product")
    public void sendGetRequestGetAllProduct(){
        getAllProduct.sendGetRequestGetAllProduct();
    }
    @Then("The response status code equal 400")
    public void responseStatusCode404(){
        getAllProduct.responseStatusCode404();
    }
    @And("I receive error message")
    public void receiveErrorMessage(){
        getAllProduct.receiveErrorMessage();
    }
}