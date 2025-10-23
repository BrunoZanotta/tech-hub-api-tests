package br.com.api.factory;

import br.com.api.model.FrameworkRequestDTO;
import br.com.api.model.FrameworkResponseDTO;
import com.github.javafaker.Faker;

public class PostFrameworkFactory {

    private static final Faker faker = new Faker();

    private static FrameworkRequestDTO build( String name, String currentVersion) {
        FrameworkRequestDTO request = new FrameworkRequestDTO();
        request.setName(name);
        request.setCurrentVersion(currentVersion);
        return request;
    }

    public static FrameworkRequestDTO createFrameworkSuccess() {
        return build(
                "Spring Boot",
                "2.7.5");
    }

    public static FrameworkRequestDTO createFrameworkWithNameNull() {
        return build(
                null,
                "2.7.5");
    }

    public static FrameworkRequestDTO createFrameworkWithCurrentVersionNull() {
        return build(
                "Spring Boot",
                null);
    }

    public static FrameworkRequestDTO createFrameworkWithBothFieldsNull() {
        return build(
                null,
                null);
    }

    public static FrameworkRequestDTO createFrameworkWithEmptyName() {
        return build(
                "",
                "2.7.5");
    }

    public static FrameworkRequestDTO createFrameworkWithEmptyCurrentVersion() {
        return build(
                "Spring Boot",
                "");
    }

    public static FrameworkRequestDTO createFrameworkWithNumberInName() {
        return build(
                faker.number().digits(5),
                "");
    }
}
