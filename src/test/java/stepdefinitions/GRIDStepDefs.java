package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class GRIDStepDefs {
    WebDriver driver;
    @Given("user is on the application_url {string}")
    public void user_is_on_the_application_url(String url) throws MalformedURLException {
        URL remoteURL = new URL("http://192.168.0.14:4444");
        driver = new RemoteWebDriver(remoteURL, new ChromeOptions());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(url);

    }
    @Then("verify the page title is {string}")
    public void verify_the_page_title_is(String string) {
        String actualTitle = driver.getTitle();
        String expectedTitle = string;
        Assert.assertEquals("FAILED.. Expected title is not equal to actual title",actualTitle,expectedTitle);

    }
    @Then("close the remote driver")
    public void close_the_remote_driver() {
        driver.quit();
    }

    @Given("user is on the application_url {string} with firefox")
    public void user_is_on_the_application_url_with_firefox(String url) throws MalformedURLException {
        URL remoteURL = new URL("http://192.168.0.14:4444");
        driver = new RemoteWebDriver(remoteURL, new FirefoxOptions());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(url);
    }
}
