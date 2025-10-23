package br.com.api.test.functional;

import br.com.api.base.BaseTest;
import br.com.api.dataprovider.PostFrameworkDataProvider;
import br.com.api.model.FrameworkRequestDTO;
import io.restassured.response.Validatable;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

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
}
