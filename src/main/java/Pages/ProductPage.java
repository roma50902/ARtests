package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class ProductPage extends BasePage {
    @FindBy(xpath = ".//tr[contains(@id,'-1')]")
    private WebElement firstProductFromSearch;

    @FindBy(xpath = ".//sub[contains(@id,'photo')]")
    private WebElement productPhotos;

    @FindBy(xpath = ".//a[@class='pp_next']")
    private WebElement arrowRight;

    @FindBy(xpath = ".//img[contains(@src,'gjq64rmxpy1')]/ancestor::li[contains(@class,'selected')]")
    private WebElement secondPhoto;

    @FindBy(xpath = ".//a[contains(@link,'/prices')]")
    private WebElement listOfSellers;

    @FindBy(xpath = ".//a[contains(@href,'order')]")
    private WebElement sortByPrice;

    @FindBy(xpath = ".//a[contains(@class,'down')]")
    private WebElement arrowDown;

    @FindBy(xpath = ".//button[@name='search_but_']")
    private WebElement findButton;

    @FindBy(xpath = ".//h1[@id='search_title']")
    private WebElement searchResults;

    @FindBy(xpath = ".//h1[@class='t2 no-mobile']")
    private WebElement productTitle;

    @FindBy(xpath = ".//span[contains(@id,'visited')]/parent::li[contains(@id,'bar')]")
    private WebElement viewedProducts;

    @FindBy(xpath = ".//a[contains(@id,'visited_item')]")
    private List<WebElement> visitedItem;

    public ProductPage(WebDriver driver) {
        super(driver);
        waitForMainElements();
    }

    @Override
    public void waitForMainElements() {
        waitUtils.waitForElementVisibilityAfterShortWait(searchField);
        waitUtils.waitForElementVisibilityAfterShortWait(findButton);
        waitUtils.waitForElementVisibilityAfterShortWait(searchField);
    }

    public void enterProductInSearch(String productName) {
        WebElement search = waitUtils.waitForElementVisibilityAfterShortWait(searchField);
        search.sendKeys(productName);
    }

    public void clickFirstProductFromSearch() {
        waitUtils.clickWhenReadyAfterMiddleWait(firstProductFromSearch);
    }

    public void openProductPhotos() {
        waitUtils.clickWhenReadyAfterMiddleWait(productPhotos);
    }

    public void clickArrowRight() {
        waitUtils.clickWhenReadyAfterShortWait(arrowRight);
    }

    public boolean isSecondPhotoDisplayed() {
        return waitUtils.waitForElementVisibilityAfterLongWait(secondPhoto).isDisplayed();
    }

    public void openListOfSellers() {
        waitUtils.clickWhenReadyAfterShortWait(listOfSellers);
    }

    public void clickSortByPrice() {
        WebElement sorting = waitUtils.waitForElementVisibilityAfterShortWait(sortByPrice);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", sorting);
    }

    public boolean isArrowDownDisplayed() {
        return waitUtils.waitForElementVisibilityAfterShortWait(arrowDown).isDisplayed();
    }

    public void clickFindButton() {
        waitUtils.clickWhenReadyAfterShortWait(findButton);
    }

    public String getSearchResults() {
        return waitUtils.getElementTextAfterShortWait(searchResults);
    }

    public String getProductTitle() {
        return waitUtils.getElementTextAfterShortWait(productTitle);
    }

    public void clickViewedProducts() {
        waitUtils.clickWhenReadyAfterShortWait(viewedProducts);
    }

    public int getVisitedItemsCount() {
        return waitUtils.waitForVisibilityOfAllElementsAfterShortWait(visitedItem).size();
    }
}
