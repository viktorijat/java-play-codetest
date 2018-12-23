package steps.definitions;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import cucumber.api.java.en.When;
import steps.utilities.FileLoader;
import steps.utilities.HttpRequest;

import static org.junit.Assert.assertEquals;

public class Stepdefs {

    @When("^I post a file \"([^\"]*)\" to the service I should receive \"([^\"]*)\"$")
    public void iPostAFileToTheServiceIShouldReceive(String send, String shouldBeFileName) throws Throwable {
        String received = HttpRequest.post("http://localhost:8080/customers", FileLoader.getStringFromJson(send));
        String shouldBe = FileLoader.getStringFromJson(shouldBeFileName);

        JsonParser parser = new JsonParser();
        JsonElement receivedJson = parser.parse(received);
        JsonElement shouldBeJson = parser.parse(shouldBe);
        assertEquals(receivedJson, shouldBeJson);
    }
}
