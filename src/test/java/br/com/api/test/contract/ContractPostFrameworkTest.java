package br.com.api.test.contract;

import br.com.api.base.BaseTest;
import br.com.api.dataprovider.PostFrameworkDataProvider;
import br.com.api.model.FrameworkRequestDTO;
import io.restassured.response.Validatable;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

public class ContractPostFrameworkTest extends BaseTest {

    @Test(dataProvider = "createFrameworkSuccess", dataProviderClass = PostFrameworkDataProvider.class)
    public void validateContractPostFramework(FrameworkRequestDTO requestUser) {
        api.frameworks()
            .addFramework()
            .body(requestUser)
            .execute(Validatable::then)
            .statusCode(HttpStatus.SC_CREATED);
    }
}
