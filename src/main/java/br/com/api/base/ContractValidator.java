package br.com.api.base;

import com.atlassian.oai.validator.restassured.OpenApiValidationFilter;

public final class ContractValidator {

    private static final String SPEC_URL = System.getProperty(
            "OPENAPI_URL",
            "https://tech-hub-api.onrender.com/v3/api-docs"
    );

    private static final OpenApiValidationFilter FILTER = new OpenApiValidationFilter(SPEC_URL);

    private ContractValidator() {}

    public static OpenApiValidationFilter filter() {
        return FILTER;
    }
}