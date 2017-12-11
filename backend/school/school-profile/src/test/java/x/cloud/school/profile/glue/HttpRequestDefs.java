package x.cloud.school.profile.glue;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HttpRequestDefs extends CloudEndpointDefs {

    @When("^GET (.*)$")
    public void get(String url) {
        apply(http().get(url));
    }


    @Then("^ASSERT statusCode is (\\d+)$")
    public void assertStatusCode(int expectedStatusCode) {
        assertEquals(expectedStatusCode, response().statusCode());
    }


    @Given("^POST (.*) with body (.*) json$")
    public void postWithBodyJson(String url, String body) {
        apply(http()
                .body(body)
                .post(url));
    }

    @Then("^ASSERT body with (.*) json$")
    public void assertBody(String expectedJson) {
        assertEquals(expectedJson, response().asString());
    }

    @Then("^ASSERT body with jsonPath (.*) is equal to (.*)$")
    public void assertBodyWithJsonPathIsEqualTo(String jsonPath, String expectedValue) {
        response()
                .then()
                .assertThat()
                .body(jsonPath, equalTo(expectedValue));
    }

}
