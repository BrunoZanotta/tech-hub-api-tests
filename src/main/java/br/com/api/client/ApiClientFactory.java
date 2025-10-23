package br.com.api.client;

import br.com.api.http.RequestSpecFactory;
import io.restassured.builder.RequestSpecBuilder;

import java.util.function.Supplier;

public final class ApiClientFactory {

    private final Supplier<RequestSpecBuilder> builderSupplier;

    private ApiClientFactory(Supplier<RequestSpecBuilder> builderSupplier) {
        this.builderSupplier = builderSupplier;
    }

    public static ApiClientFactory create() {
        return new ApiClientFactory(RequestSpecFactory::defaultBuilder);
    }

    public static ApiClientFactory createWithoutValidation() {
        return new ApiClientFactory(RequestSpecFactory::builderWithoutValidation);
    }

    public FrameworksApi frameworks() {return FrameworksApi.frameworks(builderSupplier);}
}