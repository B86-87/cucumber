package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HomePage;
import pages.LoginPage;

public class AppLoginStepDefs {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    @When("user navigate the login page")
    public void user_navigate_the_login_page() {
//        homePage.homeLoginButton.click();
//        OR CALL THE READY METHOD THAT CLICK ON THE LOGIN LINK
        homePage.clickOnLoginLink();
    }
    @When("user enters username as {string} and password as {string} and click on login button")
    public void user_enters_username_as_and_password_as_and_click_on_login_button(String username, String password) {
//        sending username
        loginPage.username.sendKeys(username);
//        sending password
        loginPage.password.sendKeys(password);
//        clicking on login button
        loginPage.loginButton.click();
    }
    @Then("verify the login is successful")
    public void verify_the_login_is_successful() {
//      if userID is displayed, then login is successful
        Assert.assertTrue(homePage.userID.isDisplayed());

    }
}
