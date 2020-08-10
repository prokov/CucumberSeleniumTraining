package TestChallenge.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.PageFactory;


public class PageObject {

    public WebDriver driver;


    public PageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public LogEntries checkConsole() {

        return driver.manage().logs().get(LogType.BROWSER);

    }
}
