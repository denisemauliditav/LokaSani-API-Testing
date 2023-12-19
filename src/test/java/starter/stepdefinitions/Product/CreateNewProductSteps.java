package starter.stepdefinitions.Product;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.Product.CreateNewProduct;

public class CreateNewProductSteps {
    @Steps
    CreateNewProduct createNewProduct;

    //CreateNewDataProduct-Positive
    @Given("I set API endpoint for creating a new product is available")
    public void setAPIForCreateNewProduct() {
        createNewProduct.setAPIForCreateNewProduct();
    }

    @When("I send a request POST to create a new product with valid inputs")
    public void sendPOSTRequestForCreateNewProduct() {
        createNewProduct.sendPOSTRequestForCreateNewProduct();
    }

    @Then("I should receive the details of the newly created product")
    public void receiveValidDataForCreateNewProduct() {
        createNewProduct.receiveValidDataForCreateNewProduct();
    }


    //CreateNewDataProduct-Negative
    @When("I send a request to create a new product with duplicate fields")
    public void sendDuplicatePOSTRequestForCreateNewProduct() {
        createNewProduct.sendDuplicatePOSTRequestForCreateNewProduct();
    }

    @And("I should receive a status code of 500")
    public void responseStatusCode500ForCreateNewProduct() {
        createNewProduct.responseStatusCode500ForCreateNewProduct();
    }

    @Then("I should receive an error message error in create new data product")
    public void receiveMessageErrorDuplicateFields() {
        createNewProduct.receiveMessageErrorDuplicateFields();
    }


}
