package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HomePage {

    public HomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(partialLinkText = "Login")
    public WebElement homeLoginButton;

    @FindBy(id = "dropdown-basic-button")
    public WebElement userID;

    @FindBy(linkText = "Logout")
    public WebElement logoutLink;

    @FindBy(xpath = "//button[text()='OK']")
    public WebElement OK;

    @FindBy(xpath = "//*[@name='car']")
    public WebElement selectACar;

//    In Page Object Model, we can create important core methods
//    For example, in the HomePage, we can create a method that click the login link
//    This is not mandatory, you can do this in step definitions
//    But since this is core function, and we keep calling, we can add this method here
    public void clickOnLoginLink(){
        homeLoginButton.click();
    }


}
