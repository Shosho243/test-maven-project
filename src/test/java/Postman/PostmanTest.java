package Postman;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanTest {
    @BeforeClass
    public void setup() {
        // Установка базового URI для всех запросов
        RestAssured.baseURI = "https://postman-echo.com";
    }

    @Test
    public void testGetRequest() {
        given()
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .when()
                .get("/get")
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"))
                .body("url", equalTo("https://postman-echo.com/get?foo1=bar1&foo2=bar2"));
    }

    @Test
    public void testPostRawText() {
        Response response = given()
                .log().all()
                .contentType("text/plain")
                .body("This is expected to be sent back as part of response body.")
                .when()
                .post("/post")
                .then()
                .log().all()
                .statusCode(200)
                .body("data", equalTo("This is expected to be sent back as part of response body."))
                .extract().response();
    }

    @Test
    public void testPostFormData() {
        String jsonBody = "{\"foo1\":\"bar1\", \"foo2\":\"bar2\"}";

        Response response = given()
                .log().all()
                .contentType("application/json")
                .body(jsonBody)
                .when()
                .post("/post")
                .then()
                .log().all()
                .statusCode(200)
                .body("json.foo1", equalTo("bar1"))
                .body("json.foo2", equalTo("bar2"))
                .extract().response();

    }

    @Test
    public void testPutRequest() {
        Response response = given()
                .log().all()
                .contentType("text/plain")
                .body("This is expected to be sent back as part of response body.")
                .when()
                .put("/put")
                .then()
                .log().all()
                .statusCode(200)
                .body("data", equalTo("This is expected to be sent back as part of response body."))
                .extract().response();
    }

    @Test
    public void testPatchRequest() {
        Response response = given()
                .log().all()
                .contentType("text/plain")
                .body("This is expected to be sent back as part of response body.")
                .when()
                .patch("/patch")
                .then()
                .log().all()
                .statusCode(200)
                .body("data", equalTo("This is expected to be sent back as part of response body."))
                .extract().response();
    }

    @Test
    public void testDeleteRequest() {
        Response response = given()
                .log().all()
                .contentType("text/plain")
                .body("This is expected to be sent back as part of response body.")
                .when()
                .delete("/delete")
                .then()
                .log().all()
                .statusCode(200)
                .body("data", equalTo("This is expected to be sent back as part of response body."))
                .extract().response();

    }
}
