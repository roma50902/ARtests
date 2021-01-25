package org.example;

import Pages.ProductPage;
import org.assertj.core.api.Assertions;
import org.example.baseTests.BaseTests;
import org.testng.annotations.Test;

public class ProductsTests extends BaseTests {

    @Test
    public void verifySliderInPhotos() throws InterruptedException {
        ProductPage productPage = new ProductPage(driver);
        productPage.enterProductInSearch("Apple iPhone 11 Pro 64");
        productPage.clickFirstProductFromSearch();
        productPage.openProductPhotos();
        productPage.clickArrowRight();

        Assertions.assertThat(productPage.isSecondPhotoDisplayed())
                .as("Second photo should be displayed")
                .isTrue();
    }

    @Test
    public void sortByPrice() throws InterruptedException {
        ProductPage productPage = new ProductPage(driver);
        productPage.enterProductInSearch("Apple iPhone 11 Pro 64");
        productPage.clickFirstProductFromSearch();
        productPage.openListOfSellers();
        productPage.clickSortByPrice();

        Assertions.assertThat(productPage.isArrowDownDisplayed())
                .as("Product should be sorted from lowest price")
                .isTrue();
    }
}
