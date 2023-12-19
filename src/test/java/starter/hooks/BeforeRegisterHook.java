package starter.hooks;

import com.github.javafaker.Faker;
import io.cucumber.java.Before;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class BeforeRegisterHook {
    @Before(value = "@Register")
    public static void beforeTest() {
        Faker faker = new Faker();

        String email = faker.internet().safeEmailAddress();
        String name = faker.name().name();
        String phoneNumber = faker.phoneNumber().phoneNumber();
        String password = faker.internet().password(8, 12);

        JSONObject requestBody = new JSONObject();

        requestBody.put("email", email);
        requestBody.put("name", name);
        requestBody.put("phone_number", phoneNumber);
        requestBody.put("password", password);

        String filePath = "src/test/resources/sample/user.json";

        try {
            String jsonString = requestBody.toString();

            FileWriter fileWriter = new FileWriter(filePath);
            fileWriter.write(jsonString);
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Before(value = "@Register")
    public static void beforeTest2() {
        String name = "den";
        String emaiil = "denise212@gmail.com";
        String password = "secret";
        String phoneNumber = "092019101";

        JSONObject requestBody = new JSONObject();

        requestBody.put("name", name);
        requestBody.put("email", emaiil);
        requestBody.put("password", password);
        requestBody.put("phoneNumber", phoneNumber);

        String filePath = "src/test/resources/sample/user2.json";

        try {
            String jsonString = requestBody.toString();

            FileWriter fileWriter = new FileWriter(filePath);
            fileWriter.write(jsonString);
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}