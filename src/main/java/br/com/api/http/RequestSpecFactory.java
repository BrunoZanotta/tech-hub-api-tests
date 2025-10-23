package br.com.api.http;

import br.com.api.base.ContractValidator;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public final class RequestSpecFactory {
    private RequestSpecFactory() {}

    public static RequestSpecification defaultSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(RestAssured.baseURI)
                .setBasePath(RestAssured.basePath)
                .setContentType(ContentType.JSON)
                .addFilter(ContractValidator.filter())
                .build();
    }

    public static RequestSpecBuilder defaultBuilder() {
        return new RequestSpecBuilder()
                .setBaseUri(RestAssured.baseURI)
                .setBasePath(RestAssured.basePath)
                .setContentType(ContentType.JSON)
                .addFilter(ContractValidator.filter());
    }

    public static RequestSpecification bearerSpec(String token) {
        return defaultBuilder()
                .addHeader("Authorization", "Bearer " + token)
                .build();
    }
}