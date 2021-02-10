package org.example;

import Pages.ProductPage;
import org.assertj.core.api.Assertions;
import org.example.baseTests.BaseTests;
import org.testng.annotations.Test;

public class ProductsTests extends BaseTests {
    private static final String productToBeSearched = "Apple iPhone 12 Pro 128";

    @Test
    public void verifySliderInPhotos() {
        ProductPage productPage = new ProductPage(driver);
        productPage.enterProductInSearch(productToBeSearched);
        productPage.clickFirstProductFromSearch();
        productPage.openProductPhotos();
        productPage.clickArrowRight();

        Assertions.assertThat(productPage.isSecondPhotoDisplayed())
                .as("Second photo should be displayed")
                .isTrue();
    }

    @Test
    public void sortByPrice() {
        ProductPage productPage = new ProductPage(driver);
        productPage.enterProductInSearch(productToBeSearched);
        productPage.clickFirstProductFromSearch();
        productPage.openListOfSellers();
        productPage.clickSortByPrice();

        Assertions.assertThat(productPage.isArrowDownDisplayed())
                .as("Product should be sorted from lowest price")
                .isTrue();
    }
}
