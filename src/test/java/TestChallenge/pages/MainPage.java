package TestChallenge.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends PageObject {

    //region Locators

    @FindBy(name = "date")
    WebElement date;

    @FindBy(xpath = "/html/body/div[2]/div/div[1]/div/form/div/div/div[4]/button")
    WebElement submitBtn;

    @FindBy(xpath = "/html/body/div[2]/div[1]/div[1]/div/div/div[1]/div/div[2]/h3")
    WebElement nameLabel;

    //endregion

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public VisaPage navigateVisa(String d) {

        date.sendKeys(d);
        submitBtn.click();
        return new VisaPage(driver);

    }

    public String getNameLabel(){
        return nameLabel.getText();
    }


}


