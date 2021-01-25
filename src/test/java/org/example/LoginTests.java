package org.example;

import Pages.MainPage;
import org.assertj.core.api.Assertions;
import org.example.baseTests.BaseTests;
import org.testng.annotations.Test;

public class LoginTests extends BaseTests {

    @Test
    public void loginTest() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButton();
        mainPage.clickLoginViaEmail();
        mainPage.loginWithCreds("oleg123@mailinator.com", "1234qwer");

        Assertions.assertThat(mainPage.isUserIconDisplayed())
                .as("User icon should be shown on the right corner")
                .isTrue();
    }

    @Test
    public void loginWithIncorrectPassword() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButton();
        mainPage.clickLoginViaEmail();
        mainPage.loginWithCreds("oleg123@mailinator.com", "12345qwer");

        Assertions.assertThat(mainPage.getErrorMessageText())
                .as("Wrong password message should be shown")
                .isEqualTo("Пароль указан неверно!");
    }
}