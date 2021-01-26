package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage {
    private WebDriver driver;
    private By searchField = By.xpath(".//input[@id='ek-search']");
    private By firstProductFromSearch = By.xpath(".//tr[contains(@id,'-1')]");
    private By productPhotos = By.xpath(".//sub[contains(@id,'photo')]");
    private By arrowRight = By.xpath(".//a[@class='pp_next']");
    private By secondPhoto = By.xpath(".//img[contains(@src,'g6vjc7bn1f1')]/ancestor::li[contains(@class,'selected')]");
    private By listOfSellers = By.xpath(".//a[contains(@link,'/prices')]");
    private By sortByPrice = By.xpath(".//a[contains(@href,'order')]");
    private By arrowDown = By.xpath(".//a[contains(@class,'down')]");
    private By findButton = By.xpath(".//button[@name='search_but_']");
    private By searchResults = By.xpath(".//h1[@id='search_title']");
    private By productTitle = By.xpath(".//h1[@class='t2 no-mobile']");
    private By viewedProducts = By.xpath(".//span[contains(@id,'visited')]/parent::li[contains(@id,'bar')]");
    private By visitedItem = By.xpath(".//a[contains(@id,'visited_item')]");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterProductInSearch(String productName) throws InterruptedException {
        WebElement search = driver.findElement(searchField);
        search.sendKeys(productName);
        Thread.sleep(1000);
    }

    public void clickFirstProductFromSearch() {
        driver.findElement(firstProductFromSearch).click();
    }

    public void openProductPhotos() throws InterruptedException {
        driver.findElement(productPhotos).click();
        Thread.sleep(1000);
    }

    public void clickArrowRight() throws InterruptedException {
        driver.findElement(arrowRight).click();
        Thread.sleep(500);
    }

    public boolean isSecondPhotoDisplayed() {
        return driver.findElement(secondPhoto).isDisplayed();
    }

    public void openListOfSellers() throws InterruptedException {
        driver.findElement(listOfSellers).click();
        Thread.sleep(1000);
    }

    public void clickSortByPrice() throws InterruptedException {
        WebElement sorting = driver.findElement(sortByPrice);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", sorting);
        Thread.sleep(2000);
    }

    public boolean isArrowDownDisplayed() {
        return driver.findElement(arrowDown).isDisplayed();
    }

    public void clickFindButton() throws InterruptedException {
        driver.findElement(findButton).click();
        Thread.sleep(2000);
    }

    public String getSearchResults() {
        return driver.findElement(searchResults).getText();
    }

    public String getProductTitle() {
        return driver.findElement(productTitle).getText();
    }

    public void clickViewedProducts() {
        driver.findElement(viewedProducts).click();
    }

    public int getVisitedItemsCount() {
        return driver.findElements(visitedItem).size();
    }
}
