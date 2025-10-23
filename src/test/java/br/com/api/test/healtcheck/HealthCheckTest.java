package br.com.api.test.healtcheck;

import br.com.api.base.BaseTest;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import java.util.Collections;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class HealthCheckTest extends BaseTest {

    @Test
    public void healthCheckTest() {
        given().
            spec(spec).
            noFilters().
        when().
            get("/actuator/health").
        then().
            statusCode(HttpStatus.SC_OK)
                .body("status", equalTo("UP"));
    }
}
