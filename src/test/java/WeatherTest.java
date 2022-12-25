import base.BaseTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static io.restassured.RestAssured.*;

public class WeatherTest extends BaseTest {

    @ParameterizedTest (name = "{0} has been verified")
    @CsvFileSource (resources = "/test_database.csv")
    @Tag("Weather")
    void weatherLocationTest() {

        given()
                .spec(requestSpecification).
        when()
                .get().
        then()
                .statusCode(200);

    }
}
