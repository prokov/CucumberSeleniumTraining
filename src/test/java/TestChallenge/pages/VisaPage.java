package TestChallenge.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Slf4j
public class VisaPage extends PageObject {

    //region Locators

    @FindBy(name = "first_name")
    WebElement firstName;

    @FindBy(name = "last_name")
    WebElement lastName;

    @FindBy(name = "email")
    WebElement email;

    @FindBy(name = "confirmemail")
    WebElement confirmEmail;

    @FindBy(name = "date")
    WebElement date;


    @FindBy(id = "sub")
    WebElement submitBtn;

    @FindBy(name = "phone")
    WebElement phone;

    //endregion


    final String mail = "mail@mail.com"; //TODO to understand what's wrong with email sent from feature file

    public VisaPage(WebDriver driver) {
        super(driver);
    }


    public String submitApp(String name, String surname, String tel, String d)  {

        firstName.sendKeys(name);
        lastName.sendKeys(surname);
        phone.sendKeys(tel);
        email.sendKeys( mail);
        confirmEmail.sendKeys(mail);
        date.sendKeys(d);
        submitBtn.click();
        return driver.findElement(By.xpath("//*[@id='submi']/div/h4[1]/strong")).getText();

    }


}


