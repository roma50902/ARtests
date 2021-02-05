package org.example;

import Pages.MainPage;
import org.assertj.core.api.Assertions;
import org.example.baseTests.BaseTests;
import org.testng.annotations.Test;

public class NavigationTests extends BaseTests {

    @Test
    public void openGadgetsMobileSection() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickGadgetsPhones();

        Assertions.assertThat(mainPage.isSectionWithProductDisplayed())
                .as("Page with phones should be displayed")
                .isTrue();
    }

    @Test
    public void verifySlider() {
        MainPage mainPage = new MainPage(driver);
        for (int i = 0; i < 3; i++) {
            mainPage.clickRightArrowSliderMainPage();
        }
        mainPage.clickPortableSpeakersSection();

        Assertions.assertThat(mainPage.isSectionWithProductDisplayed())
                .as("Section portable speakers should be opened from last slide")
                .isTrue();
    }
}
