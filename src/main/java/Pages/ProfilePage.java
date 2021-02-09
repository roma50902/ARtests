package Pages;

import Utils.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {
    private WebDriver driver;
    private WaitUtils waitUtils;
    @FindBy (xpath = ".//a[@class='info-nick']")
    private WebElement userIcon;
    @FindBy (xpath = ".//a[contains(@class,'edit')]")
    private WebElement editProfile;
    @FindBy (xpath = ".//textarea[@name='p_[SelfDescription]']")
    private WebElement descriptionField;
    @FindBy (xpath = ".//button[@type='submit']")
    private WebElement submitButton;
    @FindBy (xpath = ".//div[@class='page-title']")
    private WebElement successMessage;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
        waitUtils = new WaitUtils(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickUserIcon() {
        waitUtils.clickWhenReadyAfterShortWait(userIcon);
    }

    public void clickEditProfile() {
        waitUtils.clickWhenReadyAfterShortWait(editProfile);
    }

    public void fillDescriptionField(String enterDescription) {
        WebElement descriptionF = waitUtils.waitForElementVisibilityAfterShortWait(descriptionField);
        descriptionF.clear();
        descriptionF.sendKeys(enterDescription);
        waitUtils.waitForTextToBePresentInElementValueAfterShortWait(descriptionField, enterDescription);
    }

    public void clickSubmitButton() {
        waitUtils.clickWhenReadyAfterShortWait(submitButton);
    }

    public boolean isSuccessMessageDisplayed() {
        return waitUtils.waitForElementVisibilityAfterLongWait(successMessage).isDisplayed();
    }
}