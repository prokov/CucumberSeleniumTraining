package TestChallenge.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Slf4j
public class LoginPage extends PageObject {

    //region Locators
    @FindBy(name = "username")
    WebElement username;


    @FindBy(name = "password")
    WebElement password;

    @FindBy(xpath = "//*[@id='loginfrm']/button")
    WebElement submitBtn;

    //endregion

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public MainPage login(String name, String pass) {
        username.sendKeys(name);
        password.sendKeys(pass);
        submitBtn.click();
        return new MainPage(driver);

    }


}


