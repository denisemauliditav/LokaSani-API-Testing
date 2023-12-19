package starter.Event;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.GenerateToken;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class DeleteEvents {
    private static String url = "https://lokasani.my.id/";

    //As a user I can delete event with valid ID
    @Step("I set API endpoint for delete event By valid ID")
    public String setAPIForDeleteEventByValidID() {
        return url + "event/10";
    }
    @Step("I send a request to delete the event with the valid ID")
    public void sendDeleteRequestForEventByValidID() {
        SerenityRest.given().delete(setAPIForDeleteEventByValidID());

        //generate token
        String data = GenerateToken.generateToken();

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + data)
                .delete(setAPIForDeleteEventByValidID());
    }


    //case negative
    @Step("I set API endpoint for delete event By invalid ID")
    public String setAPIForEventByInvalidID() {
        return url + "event/50";
    }
    @Step("I send a request to delete the event with the invalid ID")
    public void sendDeleteRequestEventWithInvalidID() {
        SerenityRest.given().delete(setAPIForEventByInvalidID());

        //generate token
        String data = GenerateToken.generateToken();

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + data)
                .delete(setAPIForEventByInvalidID());
    }

}
