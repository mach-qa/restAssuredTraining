package weatherTasks;

import base.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class WeatherTest extends BaseTest {

    @ParameterizedTest (name = "Run test for {3} location")
    @DisplayName("Verify if GET endpoint returns a weather for requested location")
    @CsvFileSource (resources = "/test_database.csv")
    @Tag("Weather")
    @Execution(ExecutionMode.CONCURRENT)
    void shouldGETWeatherBasedOnLocation(String city, String country, int id, String expectedCity ) {

        given()
                .spec(specifications.setupRequestSpecification())
                .basePath(endpoints.getWeatherEndpoint())
                .param("q", city + "," + country).
        when()
                .get().
        then()
                .spec(specifications.setupResponseSpecification())
                .assertThat()
                .body("name", equalTo(expectedCity))
                .body("id", equalTo(id));
    }
}
