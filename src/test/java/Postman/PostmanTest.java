package Postman;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.*;

public class PostmanTest {
    @BeforeClass
    public void setup() {
        // Установка базового URI для всех запросов
        RestAssured.baseURI = "https://postman-echo.com";
    }

    @Test(description = "тестирование Get запрос проверка тела ответа сравнить значения всех полей и кода ответа")
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
                .body("headers.host",equalTo("postman-echo.com"))
                .body("headers.x-request-start",notNullValue())
                .body("headers.connection",equalTo("close"))
                .body("headers.x-forwarded-proto",equalTo("https"))
                .body("headers.x-forwarded-port",equalTo("443"))
                .body("headers.x-amzn-trace-id",notNullValue())
                .body("headers.user-agent",equalTo("Apache-HttpClient/4.5.3 (Java/21.0.2)"))
                .body("headers.accept",equalTo("*/*"))
                .body("headers.postman-token",nullValue())
                .body("headers.accept-encoding",equalTo("gzip,deflate"))
                .body("url", equalTo("https://postman-echo.com/get?foo1=bar1&foo2=bar2"));
    }

    @Test(description = "тестирование Post Raw Text запрос проверка тела ответа " +
            "сравнить значения всех полей и кода ответа")
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
                .body("headers.host",equalTo("postman-echo.com"))
                .body("headers.x-request-start",notNullValue())
                .body("headers.connection",equalTo("close"))
                .body("headers.x-forwarded-proto",equalTo("https"))
                .body("headers.x-forwarded-port",equalTo("443"))
                .body("headers.x-amzn-trace-id",notNullValue())
                .body("headers.user-agent",equalTo("Apache-HttpClient/4.5.3 (Java/21.0.2)"))
                .body("headers.accept",equalTo("*/*"))
                .body("headers.postman-token",nullValue())
                .body("headers.accept-encoding",equalTo("gzip,deflate"))
                .body("headers.cookie",nullValue())
                .extract().response();
    }

    @Test(description = "тестирование Post From Date запрос проверка тела ответа " +
            "сравнить значения всех полей и кода ответа")
    public void testPostFormData() {


        Response response = given()
                .log().all()
                .contentType("application/json")
                .when()
                .post("/post")
                .then()
                .log().all()
                .statusCode(200)
                .body("form.foo1", nullValue())
                .body("form.foo2", nullValue())
                .body("headers.host",equalTo("postman-echo.com"))
                .body("headers.x-request-start",notNullValue())
                .body("headers.connection",equalTo("close"))
                .body("headers.connect-lenght",nullValue())
                .body("headers.x-forwarded-proto",equalTo("https"))
                .body("headers.x-forwarded-port",equalTo("443"))
                .body("headers.x-amzn-trace-id",notNullValue())
                .body("headers.user-agent",equalTo("Apache-HttpClient/4.5.3 (Java/21.0.2)"))
                .body("headers.accept",equalTo("*/*"))
                .body("headers.postman-token",nullValue())
                .body("headers.accept-encoding",equalTo("gzip,deflate"))
                .body("headers.cookie",nullValue())
                .body("json.foo1", nullValue())
                .body("json.foo2", nullValue())
                .extract().response();

    }

    @Test(description = "тестирование Put запрос проверка тела ответа сравнить значения всех полей и кода ответа")
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
                .body("headers.host",equalTo("postman-echo.com"))
                .body("headers.x-request-start",notNullValue())
                .body("headers.connection",equalTo("close"))
                .body("headers.connect-lenght",nullValue())
                .body("headers.x-forwarded-proto",equalTo("https"))
                .body("headers.x-forwarded-port",equalTo("443"))
                .body("headers.x-amzn-trace-id",notNullValue())
                .body("headers.user-agent",equalTo("Apache-HttpClient/4.5.3 (Java/21.0.2)"))
                .body("headers.accept",equalTo("*/*"))
                .body("headers.postman-token",nullValue())
                .body("headers.accept-encoding",equalTo("gzip,deflate"))
                .body("headers.cookie",nullValue())
                .extract().response();
    }

    @Test(description = "тестирование Patch запрос проверка тела ответа" +
            " сравнить значения всех полей и кода ответа")
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
                .body("headers.host",equalTo("postman-echo.com"))
                .body("headers.x-request-start",notNullValue())
                .body("headers.connection",equalTo("close"))
                .body("headers.connect-lenght",nullValue())
                .body("headers.x-forwarded-proto",equalTo("https"))
                .body("headers.x-forwarded-port",equalTo("443"))
                .body("headers.x-amzn-trace-id",notNullValue())
                .body("headers.user-agent",equalTo("Apache-HttpClient/4.5.3 (Java/21.0.2)"))
                .body("headers.accept",equalTo("*/*"))
                .body("headers.postman-token",nullValue())
                .body("headers.accept-encoding",equalTo("gzip,deflate"))
                .body("headers.cookie",nullValue())
                .extract().response();
    }

    @Test(description = "тестирование Delete запрос проверка тела ответа " +
            "сравнить значения всех полей и кода ответа")
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
                .body("headers.host",equalTo("postman-echo.com"))
                .body("headers.x-request-start",notNullValue())
                .body("headers.connection",equalTo("close"))
                .body("headers.connect-lenght",nullValue())
                .body("headers.x-forwarded-proto",equalTo("https"))
                .body("headers.x-forwarded-port",equalTo("443"))
                .body("headers.x-amzn-trace-id",notNullValue())
                .body("headers.user-agent",equalTo("Apache-HttpClient/4.5.3 (Java/21.0.2)"))
                .body("headers.accept",equalTo("*/*"))
                .body("headers.postman-token",nullValue())
                .body("headers.accept-encoding",equalTo("gzip,deflate"))
                .body("headers.cookie",nullValue())
                .extract().response();

    }
}
