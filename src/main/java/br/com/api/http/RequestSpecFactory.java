package br.com.api.http;

import br.com.api.base.ContractValidator;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public final class RequestSpecFactory {
    private RequestSpecFactory() {}

    public static RequestSpecBuilder baseBuilder() {
        return new RequestSpecBuilder()
                .setBaseUri(RestAssured.baseURI)
                .setBasePath(RestAssured.basePath)
                .setContentType(ContentType.JSON);
    }

    public static RequestSpecification defaultSpec() {
        return baseBuilder()
                .addFilter(ContractValidator.filter())
                .build();
    }

    public static RequestSpecBuilder defaultBuilder() {
        return baseBuilder()
                .addFilter(ContractValidator.filter());
    }

    public static RequestSpecBuilder builderWithoutValidation() {
        return baseBuilder();
    }

    public static RequestSpecification specWithoutValidation() {
        return baseBuilder()
                .build();
    }

    public static RequestSpecification bearerSpec(String token) {
        return defaultBuilder()
                .addHeader("Authorization", "Bearer " + token)
                .build();
    }
}