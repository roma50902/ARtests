package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {
    @FindBy(xpath = ".//span[@class='wu_entr']")
    private WebElement loginButton;

    @FindBy(xpath = ".//div[contains(@class,'-ek')]")
    private WebElement loginViaEmail;

    @FindBy(xpath = ".//input[@name='l_']")
    private WebElement emailField;

    @FindBy(xpath = ".//input[@name='pw_']")
    private WebElement passwordField;

    @FindBy(xpath = ".//div[contains(@class,'signin')]//following-sibling::button[contains(@class,'ek')]")
    private WebElement signinButton;

    @FindBy(xpath = ".//div[contains(@id,'mui')]")
    private WebElement userIcon;

    @FindBy(xpath = ".//div[contains(@class, 'form-text')]")
    private WebElement ErrorMessageText;

    @FindBy(xpath = ".//div[@class='h1 ib']")
    private WebElement sectionWithProduct;

    @FindBy(xpath = ".//div[contains(@class,'right')]")
    private WebElement rightArrowSliderMainPage;

    @FindBy(xpath = ".//div[contains(@data-src,'41.')]")
    private WebElement portableSpeakers;

    public MainPage(WebDriver driver) {
        super(driver);
        waitForMainElements();
    }

    @Override
    public void waitForMainElements() {
        waitUtils.waitForElementVisibilityAfterShortWait(headerGadgets);
        waitUtils.waitForElementVisibilityAfterShortWait(rightArrowSliderMainPage);
        waitUtils.waitForElementVisibilityAfterShortWait(searchField);
    }

    public void clickLoginButton() {
        waitUtils.clickWhenReadyAfterShortWait(loginButton);
    }

    public void clickLoginViaEmail() {
        waitUtils.clickWhenReadyAfterShortWait(loginViaEmail);
    }

    public void inputEmailIntoField(String emailAddress) {
        waitUtils.waitForElementVisibilityAfterShortWait(emailField);
        emailField.sendKeys(emailAddress);
    }

    public void inputPasswordIntoField(String password) {
        waitUtils.waitForElementVisibilityAfterMiddleWait(passwordField);
        passwordField.sendKeys(password);
    }

    public void clickSigninButton() {
        waitUtils.clickWhenReadyAfterMiddleWait(signinButton);
    }

    public void loginWithCreds(String emailAddress, String password) {
        inputEmailIntoField(emailAddress);
        inputPasswordIntoField(password);
        clickSigninButton();
    }

    public boolean isUserIconDisplayed() {
        return waitUtils.waitForElementVisibilityAfterLongWait(userIcon).isDisplayed();
    }

    public String getErrorMessageText() {
        return waitUtils.getElementTextAfterShortWait(ErrorMessageText);
    }

    public void clickGadgetsPhones() {
        Actions action = new Actions(driver);
        WebElement gadgets = waitUtils.waitForElementVisibilityAfterShortWait(headerGadgets);
        action.moveToElement(gadgets).build().perform();
        waitUtils.waitForElementVisibilityAfterShortWait(headerGadgetsPhones).click();
    }

    public boolean isSectionWithProductDisplayed() {
        return waitUtils.waitForElementVisibilityAfterLongWait(sectionWithProduct).isDisplayed();
    }

    public void clickRightArrowSliderMainPage() {
        waitUtils.clickWhenReadyAfterLongWait(rightArrowSliderMainPage);
    }

    public void clickPortableSpeakersSection() {
        waitUtils.clickWhenReadyAfterShortWait(portableSpeakers);
    }
}
