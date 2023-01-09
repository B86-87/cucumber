package stepdefinitions;

import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.Driver;

public class RegExpressionsStepDefs {
    @When("^[I|i]? open \"([^\"]*)\" page")
    public void i_open_google_page(String URL) {
        Driver.getDriver().get(URL);

    }
    @When("^user open \"([^\"]*)\" page and search \"([^\"]*)\" text")
    public void user_types_in_the_box(String URL, String text) {
        Driver.getDriver().get(URL);
        Driver.getDriver().findElement(By.name("q")).sendKeys(text+ Keys.ENTER);
    }
}
