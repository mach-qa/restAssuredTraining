package base;

import apiEngine.Endpoints;
import apiEngine.ReqResSpecifications;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import providers.PropertiesFactory;

public class BaseTest {
    private static PropertiesFactory propertiesFactory;
    protected Endpoints endpoints = new Endpoints();
    protected ReqResSpecifications specifications = new ReqResSpecifications();

    @BeforeAll
    public static void setup() {
        propertiesFactory = PropertiesFactory.getInstance();
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }
}
