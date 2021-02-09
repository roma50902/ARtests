package Utils;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WaitUtils {
    private WebDriver driver;
    public static final int SHORT_WAIT = 5;
    public static final int MIDDLE_WAIT = 10;
    public static final int LONG_WAIT = 15;

    public WaitUtils(WebDriver driver) {
        this.driver = driver;
    }

    public void clickWhenReady(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.elementToBeClickable(element))
                .click();
    }

    public void clickWhenReadyAfterShortWait(WebElement element) {
        clickWhenReady(element, SHORT_WAIT);
    }

    public void clickWhenReadyAfterMiddleWait(WebElement element) {
        clickWhenReady(element, MIDDLE_WAIT);
    }

    public void clickWhenReadyAfterLongWait(WebElement element) {
        clickWhenReady(element, LONG_WAIT);
    }

    public WebElement waitForElementVisibility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForElementVisibilityAfterShortWait(WebElement element) {
        return waitForElementVisibility(element, SHORT_WAIT);
    }

    public WebElement waitForElementVisibilityAfterMiddleWait(WebElement element) {
        return waitForElementVisibility(element, MIDDLE_WAIT);
    }

    public WebElement waitForElementVisibilityAfterLongWait(WebElement element) {
        return waitForElementVisibility(element, LONG_WAIT);
    }

    public String getElementTextAfterShortWait(WebElement element) {
        return waitForElementVisibility(element, SHORT_WAIT).getText();
    }

    public String getElementTextAfterMiddleWait(WebElement element) {
        return waitForElementVisibility(element, MIDDLE_WAIT).getText();
    }

    public String getElementTextAfterLongWait(WebElement element) {
        return waitForElementVisibility(element, LONG_WAIT).getText();
    }

    public List<WebElement> waitForVisibilityOfAllElements(List<WebElement> element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.visibilityOfAllElements(element));
    }

    public List<WebElement> waitForVisibilityOfAllElementsAfterShortWait(List<WebElement> element) {
        return waitForVisibilityOfAllElements(element, SHORT_WAIT);
    }

    public List<WebElement> waitForVisibilityOfAllElementsAfterMiddleWait(List<WebElement> element) {
        return waitForVisibilityOfAllElements(element, MIDDLE_WAIT);
    }

    public List<WebElement> waitForVisibilityOfAllElementsAfterLongWait(List<WebElement> element) {
        return waitForVisibilityOfAllElements(element, LONG_WAIT);
    }

    public void waitForInvisibilityOf(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void waitForInvisibilityOfAfterShortWait(WebElement element) {
        waitForInvisibilityOf(element, SHORT_WAIT);
    }

    public void waitForInvisibilityOfAfterMiddleWait(WebElement element) {
        waitForInvisibilityOf(element, MIDDLE_WAIT);
    }

    public void waitForInvisibilityOfAfterLongWait(WebElement element) {
        waitForInvisibilityOf(element, LONG_WAIT);
    }

    public void waitForTextToBePresentInElementValue(WebElement element, String text, int timeout) {
        Wait fluentWait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(StaleElementReferenceException.class);

        fluentWait.until(ExpectedConditions.textToBePresentInElementValue(element, text));
    }

    public void waitForTextToBePresentInElementValueAfterShortWait(WebElement element, String text) {
        waitForTextToBePresentInElementValue(element, text, SHORT_WAIT);
    }

    public void waitForTextToBePresentInElementValueAfterMiddleWait(WebElement element, String text) {
        waitForTextToBePresentInElementValue(element, text, MIDDLE_WAIT);
    }

    public void waitForTextToBePresentInElementValueAfterLongWait(WebElement element, String text) {
        waitForTextToBePresentInElementValue(element, text, LONG_WAIT);
    }
}