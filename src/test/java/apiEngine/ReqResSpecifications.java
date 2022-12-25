package apiEngine;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;

public class ReqResSpecifications {

    private final Endpoints endpoints = new Endpoints();

    public RequestSpecification setupRequestSpecification() {
        return RestAssured.given()
                .baseUri(endpoints.getBaseUri())
                .param("appid", System.getProperty("appId"))
                .contentType(ContentType.JSON);
    }

    public ResponseSpecification setupResponseSpecification() {
        return RestAssured.expect()
                .contentType(ContentType.JSON)
                .statusCode(200)
                .time(Matchers.lessThan(5000L));
    }
}
