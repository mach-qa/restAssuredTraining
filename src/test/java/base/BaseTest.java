package base;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import providers.PropertiesFactory;

public class BaseTest {
    private static PropertiesFactory propertiesFactory;
    private static RequestSpecification requestSpecification;
    public static final String BASE_WEATHER_URL = System.getProperty("weatherPageEndpoint");

    private static Logger log = LoggerFactory.getLogger(BaseTest.class);

    @BeforeAll
    public static void setup() {
        propertiesFactory = PropertiesFactory.getInstance();
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

    // TODO poprawić tak aby pasowało pod weatherTest
    @BeforeEach
    protected void setupRequestSpecification() {
        requestSpecification = RestAssured.given()
                .baseUri(BASE_WEATHER_URL);
    }
}
