package br.com.api.dataprovider;

import org.testng.annotations.DataProvider;

import static br.com.api.factory.PostFrameworkFactory.*;

public class PostFrameworkDataProvider {

    @DataProvider(name = "createFrameworkSuccess")
    public static Object[][] providerCreateFrameworkSuccess() {
        return new Object[][]{
                {createFrameworkSuccess()}
        };
    }

    @DataProvider(name = "createFrameworkWithNameNull")
    public static Object[][] providerCreateFrameworkWithNameNull() {
        return new Object[][]{
                {createFrameworkWithNameNull()}
        };
    }

    @DataProvider(name = "createFrameworkWithCurrentVersionNull")
    public static Object[][] providerCreateFrameworkWithCurrentVersionNull() {
        return new Object[][]{
                {createFrameworkWithCurrentVersionNull()}
        };
    }

    @DataProvider(name = "createFrameworkWithBothFieldsNull")
    public static Object[][] providerCreateFrameworkWithBothFieldsNull() {
        return new Object[][]{
                {createFrameworkWithBothFieldsNull()}
        };
    }

    @DataProvider(name = "createFrameworkWithEmptyName")
    public static Object[][] providerCreateFrameworkWithEmptyName() {
        return new Object[][]{
                {createFrameworkWithEmptyName()}
        };
    }

    @DataProvider(name = "createFrameworkWithEmptyCurrentVersion")
    public static Object[][] providerCreateFrameworkWithEmptyCurrentVersion() {
        return new Object[][]{
                {createFrameworkWithEmptyCurrentVersion()}
        };
    }

    @DataProvider(name = "createFrameworkWithNumberInName")
    public static Object[][] providerCreateFrameworkWithNumberInName() {
        return new Object[][]{
                {createFrameworkWithNumberInName()}
        };
    }


}
