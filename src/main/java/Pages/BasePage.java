package Pages;

import Utils.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    protected WebDriver driver;
    protected WaitUtils waitUtils;

    @FindBy(xpath = ".//input[@id='ek-search']")
    protected WebElement searchField;

    @FindBy(xpath = ".//a[contains(@class,'first')]")
    protected WebElement headerGadgets;

    @FindBy(xpath = ".//a[contains(@class,'icon122')]")
    protected WebElement headerGadgetsPhones;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        waitUtils = new WaitUtils(driver);
        PageFactory.initElements(driver, this);
    }

    public abstract void waitForMainElements();
}
