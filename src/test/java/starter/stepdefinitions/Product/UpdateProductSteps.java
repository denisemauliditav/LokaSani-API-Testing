package starter.stepdefinitions.Product;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import net.thucydides.core.annotations.Steps;
import starter.Product.UpdateProduct;

public class UpdateProductSteps {
    @Steps
    UpdateProduct updateProduct;

    //// @Case-Positive-updateProduct1
    @Given("I set API for update product")
    public void setAPIForUpdateProduct() {
        updateProduct.setAPIForUpdateProduct();
    }
    @When("I send request PUT to update product with name only")
    public void sendPUTRequestWithNameOnly() {
        updateProduct.sendPUTRequestWithNameOnly();
    }
    @Then("The response status code should be 200")
    public void receiveStatusShouldEqualCode200() {
        updateProduct.receiveStatusShouldEqualCode200();
    }
    @And("The response should contain the details of the updated product with the changed name")
    public void receiveValidDataForUpdateProductWithNameOnly() {
        updateProduct.receiveValidDataForUpdateProductWithNameOnly();
    }

    //// @Case-Positive-updateProduct2
    @When("I send request PUT to update product with price only")
    public void sendPUTRequestWithPriceOnly() {
        updateProduct.sendPUTRequestWithPriceOnly();
    }
    @And("The response should contain the details of the updated product with the changed price")
    public void receiveValidDataForUpdateProductWithPriceOnly() {
        updateProduct.receiveValidDataForUpdateProductWithPriceOnly();
    }

    //// @Case-Positive-updateProduct3
    @When("I send request PUT to update product with description only")
    public void sendPUTRequestWithDescriptionOnly() {
        updateProduct.sendPUTRequestWithDescriptionOnly();
    }
    @And("The response should contain the details of the updated product with the changed description")
    public void receiveValidDataForUpdateProductWithDescriptionOnly() {
        updateProduct.receiveValidDataForUpdateProductWithDescriptionOnly();
    }



    //// @Case-Negative-updateProduct1
    @Given("I set API for update product with invalid ID")
    public void setInvalidAPIEndpointUpdateProduct() {
        updateProduct.setInvalidAPIEndpointUpdateProduct();
    }
    @When("I send request PUT to update product with invalid ID")
    public void sendInvalidRequestUpdateProduct() {
        updateProduct.sendInvalidRequestUpdateProduct();
    }
    @Then("The response status code should be 404")
    public void receiveStatusCode404InUpdateProduct() {
        updateProduct.receiveStatusCode404InUpdateProduct();
    }
   @And("The response should contain an error message indicating that the product ID is not found")
    public void responsePageNotFoundOnTheUpdateProduct() {
        updateProduct.responsePageNotFoundOnTheUpdateProduct();
    }


    //// @Case-Negative-updateProduct2
    @Given("I set API for update product with empty ID")
    public void setInvalidAPIEndpointUpdateProductWIthEmptyID() {
        updateProduct.setInvalidAPIEndpointUpdateProductWIthEmptyID();
    }
    @When("I send request PUT to update product with empty ID")
    public void sendInvalidRequestUpdateProductWithEmptyID() {
        updateProduct.sendInvalidRequestUpdateProductWithEmptyID();
    }
    @Then("The response status code should be 405")
    public void receiveStatusCode405InUpdateProduct() {
        updateProduct.receiveStatusCode405InUpdateProduct();
    }
   @And("The response should contain an error message indicating that the update data is not found")
    public void responseUpdateProductNotFound() {
        updateProduct.responseUpdateProductNotFound();
    }




}
