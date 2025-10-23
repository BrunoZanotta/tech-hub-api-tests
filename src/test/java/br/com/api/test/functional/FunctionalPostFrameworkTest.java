package br.com.api.test.functional;

import br.com.api.base.BaseTest;
import br.com.api.dataprovider.PostFrameworkDataProvider;
import br.com.api.model.FrameworkRequestDTO;
import io.restassured.response.Validatable;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class FunctionalPostFrameworkTest extends BaseTest {

    @Test(dataProvider = "createFrameworkSuccess", dataProviderClass = PostFrameworkDataProvider.class)
    public void validateFunctionalPostFrameworkSuccess(FrameworkRequestDTO requestFramework) {
        api.frameworks()
                .addFramework()
                .body(requestFramework)
                .execute(Validatable::then)
                .statusCode(HttpStatus.SC_CREATED)
                .body("id", notNullValue())
                .body("name", equalTo(requestFramework.getName()))
                .body("currentVersion", equalTo(requestFramework.getCurrentVersion()));
    }

    @Test(dataProvider = "createFrameworkWithNameNull", dataProviderClass = PostFrameworkDataProvider.class)
    public void validateFunctionalPostFrameworkWithNameNull(FrameworkRequestDTO requestFramework) {
        apiWithoutValidation.frameworks()
                .addFramework()
                .body(requestFramework)
                .execute(Validatable::then)
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .body("status", equalTo(HttpStatus.SC_BAD_REQUEST))
                .body("error", equalTo("Bad Request"))
                .body("message", equalTo("name null"));
    }

    @Test(dataProvider = "createFrameworkWithCurrentVersionNull", dataProviderClass = PostFrameworkDataProvider.class)
    public void validateFunctionalPostFrameworkWithCurrentVersionNull(FrameworkRequestDTO requestFramework) {
        apiWithoutValidation.frameworks()
                .addFramework()
                .body(requestFramework)
                .execute(Validatable::then)
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .body("status", equalTo(HttpStatus.SC_BAD_REQUEST))
                .body("error", equalTo("Bad Request"))
                .body("message", equalTo("Invalid request body"));
    }

    @Test(dataProvider = "createFrameworkWithBothFieldsNull", dataProviderClass = PostFrameworkDataProvider.class)
    public void validateFunctionalPostFrameworkWithBothFieldsNull(FrameworkRequestDTO requestFramework) {
        apiWithoutValidation.frameworks()
                .addFramework()
                .body(requestFramework)
                .execute(Validatable::then)
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .body("status", equalTo(HttpStatus.SC_BAD_REQUEST))
                .body("error", equalTo("Bad Request"))
                .body("message", equalTo("name null"));
    }

    @Test(dataProvider = "createFrameworkWithEmptyName", dataProviderClass = PostFrameworkDataProvider.class)
    public void validateFunctionalPostFrameworkWithEmptyName(FrameworkRequestDTO requestFramework) {
        apiWithoutValidation.frameworks()
                .addFramework()
                .body(requestFramework)
                .execute(Validatable::then)
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .body("status", equalTo(HttpStatus.SC_BAD_REQUEST))
                .body("error", equalTo("Bad Request"))
                .body("message", notNullValue());
    }

    @Test(dataProvider = "createFrameworkWithEmptyCurrentVersion", dataProviderClass = PostFrameworkDataProvider.class)
    public void validateFunctionalPostFrameworkWithEmptyCurrentVersion(FrameworkRequestDTO requestFramework) {
        apiWithoutValidation.frameworks()
                .addFramework()
                .body(requestFramework)
                .execute(Validatable::then)
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .body("status", equalTo(HttpStatus.SC_BAD_REQUEST))
                .body("error", equalTo("Bad Request"))
                .body("message", notNullValue());
    }

    @Test(dataProvider = "createFrameworkWithNumberInName", dataProviderClass = PostFrameworkDataProvider.class)
    public void validateFunctionalPostFrameworkWithNumberInName(FrameworkRequestDTO requestFramework) {
        apiWithoutValidation.frameworks()
                .addFramework()
                .body(requestFramework)
                .execute(Validatable::then)
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .body("status", equalTo(HttpStatus.SC_BAD_REQUEST))
                .body("error", equalTo("Bad Request"))
                .body("message", notNullValue());
    }

    @Test(dataProvider = "createFrameworkSuccess", dataProviderClass = PostFrameworkDataProvider.class)
    public void validateFunctionalPostFrameworkAlready(FrameworkRequestDTO requestFramework) {
        api.frameworks()
                .addFramework()
                .body(requestFramework)
                .execute(Validatable::then)
                .statusCode(HttpStatus.SC_CONFLICT)
                .body("status", equalTo(HttpStatus.SC_CONFLICT))
                .body("error", equalTo("Conflict"))
                .body("message", equalTo("Framework with name 'Spring Boot' and version '2.7.5' already exists."));
    }
}
