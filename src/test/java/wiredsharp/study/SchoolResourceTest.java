package wiredsharp.study;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class SchoolResourceTest {

    @Test
    public void testSchoolApiEndpoint() {
        given()
          .when().get("/api/schools")
          .then()
             .statusCode(200)
             .contentType(ContentType.JSON);
    }

    @Test
    public void testGetById() {
        given()
          .when().get("/api/schools/1")
          .then()
             .statusCode(200)
             .contentType(ContentType.JSON);
    }

    @Test
    public void testGetByUnknownId() {
        given()
          .when().get("/api/schools/999999")
          .then()
             .statusCode(404)
             .contentType(ContentType.JSON);
    }
}