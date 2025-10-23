package br.com.api.base;

import br.com.api.client.ApiClientFactory;
import br.com.api.http.RequestSpecFactory;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

import static io.restassured.RestAssured.enableLoggingOfRequestAndResponseIfValidationFails;

public class BaseTest {

    public RequestSpecification spec;
    public ApiClientFactory api;
    public ApiClientFactory apiWithoutValidation;

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = "https://tech-hub-api.onrender.com";
        RestAssured.basePath = "";
        spec = RequestSpecFactory.defaultSpec();
        api = ApiClientFactory.create();
        apiWithoutValidation = ApiClientFactory.createWithoutValidation();

        enableLoggingOfRequestAndResponseIfValidationFails();
    }
}