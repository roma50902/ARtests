package org.example;

import Pages.MainPage;
import Pages.ProfilePage;
import org.assertj.core.api.Assertions;
import org.example.baseTests.BaseTests;
import org.testng.annotations.Test;

public class ProfileTests extends BaseTests {

    @Test
    public void addTextInProfileInfo() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButton();
        mainPage.clickLoginViaEmail();
        mainPage.loginWithCreds("oleg123@mailinator.com", "1234qwer");

        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.clickUserIcon();
        profilePage.clickEditProfile();
        profilePage.fillDescriptionField("Hello");
        profilePage.clickSubmitButton();

        Assertions.assertThat(profilePage.isSuccessMessageDisplayed())
                .as("Success message should be displayed")
                .isTrue();
    }
}
