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

    @FindBy(xpath = "//input[@name='pickUpLocation']")
    public WebElement pickUp;


    @FindBy(xpath = "//input[@name='dropOfLocation']")
    public WebElement dropOff;

    @FindBy(xpath = "//input[@name='pickUpDate']")
    public WebElement pickUpDate;
    @FindBy(xpath = "//input[@name='pickUpTime']")
    public WebElement pickUpTime;

    @FindBy(xpath = "//input[@name='dropOffDate']")
    public WebElement dropOffDate;
    @FindBy(xpath = "//input[@name='dropOffTime']")
    public WebElement dropOffTime;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement continueReservation;

    @FindBy(xpath = "//div[text()='Complete Reservation']")
    public WebElement completeReservationPage;

    @FindBy(xpath = "//input[@name='cardNo']")
    public WebElement cardNumber;
    @FindBy(xpath = "//input[@name='nameOnCard']")
    public WebElement nameOnTheCard;
    @FindBy(xpath = "//input[@name='expireDate']")
    public WebElement expireDate;
    @FindBy(xpath = "//input[@name='cvc']")
    public WebElement CVC;
    @FindBy(xpath = "//input[@name='contract']")
    public WebElement agreementCheckBox;
    @FindBy(xpath = "(//button[@type='submit'])[last()]")
    public WebElement completeReservation;
    @FindBy(xpath = "(//div[@class='modal-footer']//button[@type='button'])")
    public WebElement closeButton;
    @FindBy(xpath =" //*[.='Reservation created successfully']")
    public WebElement reservationSuccess;






//    In Page Object Model, we can create important core methods
//    For example, in the HomePage, we can create a method that click the login link
//    This is not mandatory, you can do this in step definitions
//    But since this is core function, and we keep calling, we can add this method here
    public void clickOnLoginLink(){
        homeLoginButton.click();
    }


}
