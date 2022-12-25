package weatherTasks;

import base.BaseTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class WeatherTest extends BaseTest {

    @ParameterizedTest (name = "Run test for {3} location")
    @CsvFileSource (resources = "/test_database.csv")
    @Tag("Weather")
    void shouldGETWeatherBasedOnLocation(String city, String country, int id, String expectedCity ) {

        given()
                .spec(setupRequestSpecification())
                .param("q", city + "," + country).
        when()
                .get().
        then()
                .spec(setupResponseSpecification())
                .assertThat()
                .body("name", equalTo(expectedCity))
                .body("id", equalTo(id));
    }
}
