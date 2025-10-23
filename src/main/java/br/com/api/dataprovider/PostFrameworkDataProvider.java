package br.com.api.dataprovider;

import org.testng.annotations.DataProvider;

import static br.com.api.factory.PostFrameworkFactory.createFrameworkSuccess;

public class PostFrameworkDataProvider {

    @DataProvider(name = "createFrameworkSuccess")
    public static Object[][] providerCreateFrameworkSuccess() {
        return new Object[][]{
                {createFrameworkSuccess()}
        };
    }
}
