package starter.stepdefinitions.Product;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.Product.DeleteProductByID;



public class DeleteProductByIDSteps {
    @Steps
    DeleteProductByID deleteProductByID;

    @Given("I set API endpoint for delete product By valid ID")
    public void setAPIForDeleteProductByID(){
        deleteProductByID.setAPIForDeleteProductByID();
    }
    @When("I send a request to delete the product with the valid ID")
    public void sendDeleteRequestForDeleteProductByID(){
        deleteProductByID.sendDeleteRequestForDeleteProductByID();
    }
    @And("I should receive a status code of 200")
    public void receiveStatusCode200ForDeleteProduct(){
        deleteProductByID.receiveStatusCode200ForDeleteProduct();
    }
    @Then("The product was deleted successfully")
    public void receiveSuccessfullyMessage(){
        deleteProductByID.receiveSuccessfullyMessage();
    }


//case negative
    @Given("I set API endpoint for delete product By invalid ID")
    public void setInvalidAPIForDeleteProductByID(){
        deleteProductByID.setInvalidAPIForDeleteProductByID();
    }
    @When("I send a request to delete the product with the invalid ID")
    public void sendDeleteRequestInvalidForDeleteProductByID(){
        deleteProductByID.sendDeleteRequestInvalidForDeleteProductByID();
    }
    @And("I should receive a status code of 404")
    public void responseStatusCode404ForGetProductByID(){
        deleteProductByID.responseStatusCode404ForGetProductByID();
    }
  @Then("The product fails to be deleted and an error message appears that product data not found")
    public void receiveMessageErrorShouldIndicatePageNotFound(){
        deleteProductByID.receiveMessageErrorShouldIndicatePageNotFound();
    }



}
