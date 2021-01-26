package org.example;

import Pages.ProductPage;
import org.assertj.core.api.Assertions;
import org.example.baseTests.BaseTests;
import org.testng.annotations.Test;

public class SearchTests extends BaseTests {

    @Test
    public void VerifySearch() throws InterruptedException {
        ProductPage productPage = new ProductPage(driver);
        productPage.enterProductInSearch("Apple iPhone 12");
        productPage.clickFindButton();

        Assertions.assertThat(productPage.getSearchResults())
                .as("No Results Found' should not be shown")
                .contains("По запросу Apple iPhone 12 найдено");
    }

    @Test
    public void openProductFromSearch() throws InterruptedException {
        ProductPage productPage = new ProductPage(driver);
        productPage.enterProductInSearch("Apple iPhone 11 Pro 64");
        productPage.clickFirstProductFromSearch();

        Assertions.assertThat(productPage.getProductTitle())
                .as("Page with iPhone should be shown")
                .contains("Apple iPhone 11 Pro 64");
    }

    @Test
    public void verifyViewedProductsInHistory() throws InterruptedException {
        ProductPage productPage = new ProductPage(driver);
        productPage.enterProductInSearch("Apple iPhone 11 Pro 64");
        productPage.clickFirstProductFromSearch();
        productPage.enterProductInSearch("OnePlus 8 Pro 128");
        productPage.clickFirstProductFromSearch();
        productPage.clickViewedProducts();

        Assertions.assertThat(productPage.getVisitedItemsCount())
                .as("'No Results Found' should not be shown")
                .isEqualTo(2);
    }
}
