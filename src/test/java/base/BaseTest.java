package base;

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
    private static RequestSpecification requestSpecification;
    private static ResponseSpecification responseSpecification;
    public final String BASE_WEATHER_URL = System.getProperty("baseWeatherURL");
    public final String WEATHER_DATA_PATH = System.getProperty("weatherDataEndpoint");

    @BeforeAll
    public static void setup() {
        propertiesFactory = PropertiesFactory.getInstance();
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

    protected RequestSpecification setupRequestSpecification() {
        return requestSpecification = RestAssured.given()
                .baseUri(BASE_WEATHER_URL)
                .param("appid", System.getProperty("appId"))
                .contentType(ContentType.JSON);
    }

    protected ResponseSpecification setupResponseSpecification() {
        return responseSpecification = RestAssured.expect()
                .contentType(ContentType.JSON)
                .statusCode(200)
                .time(Matchers.lessThan(5000L));
    }
}
