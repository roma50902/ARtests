package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MainPage {
    private WebDriver driver;
    private By loginButton = By.xpath(".//span[@class='wu_entr']");
    private By loginViaEmail = By.xpath(".//div[contains(@class,'-ek')]");
    private By emailField = By.xpath(".//input[@name='l_']");
    private By passwordField = By.xpath(".//input[@name='pw_']");
    private By signinButton = By.xpath(".//div[contains(@class,'signin')]//following-sibling::button[contains(@class,'ek')]");
    private By userIcon = By.xpath(".//div[contains(@id,'mui')]");
    private By ErrorMessageText = By.xpath(".//div[contains(@class, 'form-text')]");
    private By headerGadgets = By.xpath(".//a[contains(@class,'first')]");
    private By headerGadgetsPhones = By.xpath(".//a[contains(@class,'icon122')]");
    private By sectionWithProduct = By.xpath(".//div[@class='h1 ib']");
    private By rightArrowSliderMainPage = By.xpath(".//div[contains(@class,'right')]");
    private By portableSpeakers = By.xpath(".//div[contains(@data-src,'41.')]");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLoginButton() throws InterruptedException {
        driver.findElement(loginButton).click();
        Thread.sleep(1000);
    }

    public void clickLoginViaEmail() throws InterruptedException {
        driver.findElement(loginViaEmail).click();
        Thread.sleep(1000);
    }

    public void inputEmailIntoField(String emailAdress) {
        WebElement email = driver.findElement(emailField);
        email.sendKeys(emailAdress);
    }

    public void inputPasswordIntoField(String password) {
        WebElement pass = driver.findElement(passwordField);
        pass.sendKeys(password);
    }

    public void clickSigninButton() throws InterruptedException {
        WebElement signIn = driver.findElement(signinButton);
        if (signIn.isEnabled()) {
            signIn.click();
        }
        Thread.sleep(2000);
    }

    public void loginWithCreds(String emailAdress, String password) throws InterruptedException {
        inputEmailIntoField(emailAdress);
        inputPasswordIntoField(password);
        clickSigninButton();
    }

    public boolean isUserIconDisplayed() {

        return driver.findElement(userIcon).isDisplayed();
    }

    public String getErrorMessageText() {

        return driver.findElement(ErrorMessageText).getText();
    }

    public void hoverOverOnHeaderGadgets() throws InterruptedException {
        Actions action = new Actions(driver);
        WebElement gadgets = driver.findElement(headerGadgets);
        action.moveToElement(gadgets).build().perform();
        Thread.sleep(1000);
    }

    public void clickGadgetsPhones() throws InterruptedException {
        driver.findElement(headerGadgetsPhones).click();
        Thread.sleep(2000);
    }

    public boolean isSectionWithProductDisplayed() {

        return driver.findElement(sectionWithProduct).isDisplayed();
    }

    public void clickRightArrowSliderMainPage() {

        driver.findElement(rightArrowSliderMainPage).click();
    }

    public void clickPortableSpeakersSection() {
        driver.findElement(portableSpeakers).click();
    }
}
