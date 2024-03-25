package ua.automation.hw8;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.notNullValue;
import static io.restassured.RestAssured.when;

public class RestAssuredTests {

    @BeforeClass
    public void InitBaseUrl() {

        RestAssured.baseURI = "https://api.github.com/";
    }

    @Test
    public void getGitHubEmojis() {
        var response = when().get("emojis").then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("articulated_lorry", notNullValue())
                .extract().response();

        System.out.println(response.jsonPath().getString("articulated_lorry"));
    }
}
