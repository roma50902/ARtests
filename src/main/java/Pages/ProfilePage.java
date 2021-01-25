package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePage {
    private WebDriver driver;
    private By userIcon = By.xpath(".//a[@class='info-nick']");
    private By editProfile = By.xpath(".//a[contains(@class,'edit')]");
    private By descriptionField = By.xpath(".//textarea[@name='p_[SelfDescription]']");
    private By submitButton = By.xpath(".//button[@type='submit']");
    private By successMessage = By.xpath(".//div[@class='page-title']");

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickUserIcon() {
        driver.findElement(userIcon).click();
    }

    public void clickEditProfile() {
        driver.findElement(editProfile).click();
    }

    public void fillDescriptionField(String enterDescription) throws InterruptedException {
        WebElement descriptionF = driver.findElement(descriptionField);
        descriptionF.clear();
        descriptionF.sendKeys(enterDescription);
        Thread.sleep(1000);
    }

    public void clickSubmitButton() {
        driver.findElement(submitButton).click();
    }

    public boolean isSuccessMessageDisplayed() {

        return driver.findElement(successMessage).isDisplayed();
    }
}
