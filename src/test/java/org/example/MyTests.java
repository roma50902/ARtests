package org.example;

import org.assertj.core.api.Assertions;
import org.example.baseTests.BaseTests;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MyTests extends BaseTests {

    @Test
    public void loginTest() throws InterruptedException {
        driver.findElement(By.className("wu_entr")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(".//div[contains(@class, 'signin-with-ek')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.className("ek-form-control")).click();
        Thread.sleep(1000);
        WebElement emailField = driver.findElement(By.xpath(".//input[@name='l_']"));
        emailField.sendKeys("oleg123@mailinator.com");
        WebElement passwordField = driver.findElement(By.xpath(".//input[@name='pw_']"));
        passwordField.clear();
        passwordField.sendKeys("1234qwer", Keys.ENTER);
        Thread.sleep(2000);

        Assertions.assertThat(driver.findElement(By.id("mui_user_login_row")).isDisplayed())
                .as("User icon is shown on the right corner")
                .isTrue();
    }

    @Test
    public void loginWithIncorrectPassword() throws InterruptedException {
        driver.findElement(By.className("wu_entr")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(".//div[contains(@class, 'signin-with-ek')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.className("ek-form-control")).click();
        Thread.sleep(1000);
        WebElement emailField = driver.findElement(By.xpath(".//input[@name='l_']"));
        emailField.sendKeys("oleg123@mailinator.com");
        WebElement passwordField = driver.findElement(By.xpath(".//input[@name='pw_']"));
        passwordField.clear();
        passwordField.sendKeys("12345qwer", Keys.ENTER);
        Thread.sleep(2000);

        Assertions.assertThat(driver.findElement(By.xpath(".//div[contains(@class, 'ek-form-text')]")).getText())
                .as("Message about wrong password is shown")
                .isEqualTo("Пароль указан неверно!");
    }

    @Test
    public void addTextInProfileInfo() throws InterruptedException {
        driver.findElement(By.className("wu_entr")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(".//div[contains(@class, 'signin-with-ek')]")).click();
        driver.findElement(By.className("ek-form-control")).click();
        Thread.sleep(1000);
        WebElement emailField = driver.findElement(By.xpath(".//input[@name='l_']"));
        emailField.sendKeys("oleg123@mailinator.com");
        WebElement passwordField = driver.findElement(By.xpath(".//input[@name='pw_']"));
        passwordField.clear();
        passwordField.sendKeys("1234qwer", Keys.ENTER);
        Thread.sleep(1000);

        driver.findElement(By.className("info-nick")).click();
        driver.findElement(By.className("user-menu__edit")).click();
        WebElement dedcriptionField = driver.findElement(By.name("p_[SelfDescription]"));
        dedcriptionField.sendKeys("Hello");
        Thread.sleep(1000);
        driver.findElement(By.xpath(".//*[@type='submit']")).click();
        Thread.sleep(1000);

        Assertions.assertThat(driver.findElement(By.xpath(".//div[@class='page-title']")).isDisplayed())
                .as("Success message is displayed")
                .isTrue();
    }

    @Test
    public void VerifySearch() throws InterruptedException {
        WebElement searchField = driver.findElement((By.id("ek-search")));
        searchField.sendKeys("Apple iPhone 12");
        Thread.sleep(1000);
        driver.findElement(By.xpath(".//*[@name='search_but_']")).click();
        Thread.sleep(2000);

        Assertions.assertThat(driver.findElement(By.id("search_title")).getText())
                .as("No Results Found' is not shown")
                .contains("По запросу Apple iPhone 12 найдено");
    }

    @Test
    public void openGadgetsMobileSection5() throws InterruptedException {
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(By.linkText("Гаджеты"));
        action.moveToElement(we).build().perform();
        Thread.sleep(1000);
        driver.findElement(By.linkText("Мобильные")).click();
        Thread.sleep(2000);

        Assertions.assertThat(driver.findElement(By.linkText("Мобильные телефоны")).isDisplayed())
                .as("Page with phones is displayed")
                .isTrue();
    }

    @Test
    public void openProductFromSearsh() throws InterruptedException {
        WebElement searchField = driver.findElement((By.id("ek-search")));
        searchField.sendKeys("Apple iPhone 11 Pro 64");
        Thread.sleep(1000);
        driver.findElement(By.xpath(".//*[@class='qsdc-0']")).click();
        Thread.sleep(2000);

        Assertions.assertThat(driver.findElement(By.xpath(".//*[@class='t2 no-mobile']")).getText())
                .as("Page with iPhone is shown")
                .contains("Apple iPhone 11 Pro 64");
    }

    @Test
    public void verifySlider() throws InterruptedException {
        WebElement rightArrow = driver.findElement(By.xpath(".//div[contains(@class, 'mp-slider__nav-arrow__right')]"));
        for (int i=0;i<3;i++){
            rightArrow.click();
        }
        Thread.sleep(500);
        driver.findElement(By.xpath(".//div[@data-src='/jpg/jpg_katalog/wide/41.jpg']")).click();
        Thread.sleep(1000);

        Assertions.assertThat(driver.findElement(By.xpath(".//div[contains(@class, 'h1 ib')]")).isDisplayed())
                .as("Section portable speakers was opened from last slide")
                .isTrue();
    }

    @Test
    public void verifySliderInPhotos() throws InterruptedException {
        WebElement searchField = driver.findElement((By.id("ek-search")));
        searchField.sendKeys("Apple iPhone 11 Pro 64");
        Thread.sleep(1000);
        driver.findElement(By.xpath(".//*[@class='qsdc-0']")).click();
        driver.findElement(By.id("mobi-num-photo")).click();
        Thread.sleep(500);
        driver.findElement(By.className("pp_next")).click();
        Thread.sleep(1000);

        Assertions.assertThat(driver.findElement(By.xpath(".//*[@src='https://mzimg.com/120/f1/g6vjc7bn1f1.jpg']")).isDisplayed())
                .as("Second photo is displayed")
                .isTrue();
    }

    @Test
    public void sortByPrice() throws InterruptedException {
        WebElement searchField = driver.findElement((By.id("ek-search")));
        searchField.sendKeys("Apple iPhone 11 Pro 64");
        Thread.sleep(1000);
        driver.findElement(By.xpath(".//*[@class='qsdc-0']")).click();
        driver.findElement(By.xpath(".//*[@title='Посмотреть все предложения магазинов']")).click();
        Thread.sleep(1000);
        WebElement element = driver.findElement(By.xpath(".//a[@href='/ek-item.php?idg_=1651502&view_=prices&order_=price']"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
        Thread.sleep(2000);

        Assertions.assertThat(driver.findElement(By.xpath(".//a[@class='sort-arr-down']")).isDisplayed())
                .as("Product is sorted from lowest price")
                .isTrue();
    }

    @Test
    public void verifyViewedProductsInHistory() throws InterruptedException {
        WebElement searchField = driver.findElement((By.id("ek-search")));
        searchField.sendKeys("Apple iPhone 11 Pro 64");
        Thread.sleep(1000);
        driver.findElement(By.xpath(".//*[@class='qsdc-0']")).click();
        WebElement search1Field = driver.findElement((By.id("ek-search")));
        search1Field.sendKeys("OnePlus 8 Pro 128");
        Thread.sleep(1000);
        driver.findElement(By.xpath(".//*[@class='qsdc-0']")).click();
        driver.findElement(By.id("name_bm_visited")).click();
        Thread.sleep(1000);

        Assertions.assertThat(driver.findElements(By.xpath(".//a[contains(@id, 'visited_item')]")))
                .as("'No Results Found' is not shown")
                .hasSize(2);
    }
}