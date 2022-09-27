package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.eo.Se;
import org.openqa.selenium.support.ui.Select;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class AppReservationStepDefs {

    HomePage homePage = new HomePage();
    @Given("user is on the home page")
    public void user_is_on_the_home_page() {
//        going to the url
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
    }

    @Given("select a car model {string}")
    public void select_a_car_model(String string) {

        Select select = new Select(homePage.selectACar);
//        ReusableMethods.selectRandomTextFromDropdown(select);//selects random car
        select.selectByVisibleText(string);

    }

    @Given("enter pick up field")
    public void enter_pick_up_field() {

        homePage.pickUp.sendKeys(Faker.instance(Locale.US).address().cityName());
    }

    @Given("enter drop off field")
    public void enter_drop_off_field() {
        homePage.dropOff.sendKeys(Faker.instance(Locale.US).address().cityName());
    }
    @Given("enter pick up date")
    public void enter_pick_up_date() {
//        homePage.pickUpDate.sendKeys("10/10/2035");

    }
    @Given("enter drop off date")
    public void enter_drop_off_date() {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("ddMMyyyy");
        String today=simpleDateFormat.format(new Date());
        SimpleDateFormat simpleDateFormat1=new SimpleDateFormat("hhmmaa");
        String time= simpleDateFormat1.format(new Date());
        Calendar calendar=Calendar.getInstance();
        calendar.add(Calendar.YEAR,30);
//        homePage.pickUpDate.sendKeys(simpleDateFormat.format(calendar.getTime()));
        homePage.pickUpDate.sendKeys("10/10/2035");
        homePage.pickUpTime.sendKeys(time);
        calendar.add(Calendar.MONTH,1);
//        homePage.dropOffDate.sendKeys(simpleDateFormat.format(calendar.getTime()));
        homePage.pickUpDate.sendKeys("10/11/2035");
        calendar.add(Calendar.HOUR,1);
        homePage.dropOffTime.sendKeys(simpleDateFormat1.format(calendar.getTime()));
//        homePage.pickUpTime.sendKeys("07:00");
    }

    @Given("click continue reservation")
    public void click_continue_reservation() {

        homePage.continueReservation.click();




    }

    @Given("verify complete reservation screen pops up")
    public void verify_complete_reservation_screen_pops_up() {

    }

    @Given("enter card number")
    public void enter_card_number() {

    }

    @Given("enter name on the card")
    public void enter_name_on_the_card() {

    }

    @Given("enter expire date and CVC")
    public void enter_expire_date_and_cvc() {

    }

    @Given("checks the agreement")
    public void checks_the_agreement() {

    }

    @Given("click complete reservation")
    public void click_complete_reservation() {

    }

    @Then("verify {string} pop up")
    public void verify_pop_up(String string) {

    }

}
