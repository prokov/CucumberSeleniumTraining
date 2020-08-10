package TestChallenge;

import TestChallenge.pages.LoginPage;
import TestChallenge.pages.MainPage;
import TestChallenge.pages.PageObject;
import TestChallenge.pages.VisaPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

@Slf4j
public class Stepdefs {


    private static WebDriver driver;
    LoginPage loginPage;
    VisaPage visaPage;
    MainPage mainPage;
    String successLabel;

    final static String VISA_URL = "https://phptravels.net/visa/booking";
    final static String LOGIN_URL = "https://phptravels.net/login";

    public Stepdefs() { }

    @Given("go to Visa booking page")
    public void go_to_visa_booking_page() {
        driverSetup();
        driver.get(VISA_URL);
        visaPage = new VisaPage(driver);

    }

    @When("submit application with valid data {string}{string}{string}{string}")
    public void submit_application_with_valid_data(String date, String name, String surname, String phone) {
        successLabel = visaPage.submitApp(name, surname, phone, date);

    }

    @Then("I should see application success page {string}")
    public void i_should_see_application_success_page(String successMessage) {
        assertTrue(successLabel.contains(successMessage));
        checkConsoleLog(visaPage);
        driver.quit();
    }


    @Given("go to login page")
    public void go_to_login_page() {
        driverSetup();
        driver.get(LOGIN_URL);
        loginPage = new LoginPage(driver);

    }


    @When("login with valid credentials {string}{string}")
    public void login_with_valid_credentials(String email, String password) {
        mainPage = loginPage.login(email, password);

    }


    @Then("user is logged in {string}{string}")
    public void user_is_logged_in(String name, String surname) {
        assertTrue(mainPage.getNameLabel().contains(name) && mainPage.getNameLabel().contains(surname));
        checkConsoleLog(mainPage);
        driver.quit();

    }


    private void driverSetup() {

        ChromeOptions options = new ChromeOptions();
        LoggingPreferences loggingprefs = new LoggingPreferences();
        loggingprefs.enable(LogType.BROWSER, Level.ALL);
        options.setCapability(ChromeOptions.CAPABILITY, options);
        options.setCapability(CapabilityType.LOGGING_PREFS, loggingprefs);
        options.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);

        driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }

    //TODO Improve, in case  of empty console log will be NullPointer exception
    private void checkConsoleLog(PageObject page) {

        visaPage.checkConsole().forEach((x) -> {

                    log.info(new Date(x.getTimestamp()) + " " + x.getLevel() + " " + x.getMessage());
                    if (x.getLevel().equals(Level.SEVERE)) {
                        fail("Critical errors in Console log");

                    }
                }
        );

    }
}