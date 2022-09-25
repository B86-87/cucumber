package stepdefinitions;

import io.cucumber.java.en.Given;
import org.junit.Assert;
import pages.HomePage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExcelUtil;
import utilities.ReusableMethods;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ExcelStepDefs {
    ExcelUtil excelUtil;
    HomePage homePage;
    LoginPage loginPage;
    List<Map<String ,String >> testData; //we will store excel data in this java object as a list

    public void login(){

//        going to the url
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
//        initializing the pages
        homePage = new HomePage();
        loginPage=new LoginPage();


//        GOING TO THE LOGIN PAGE FIRST TIME
        try{
            // if there is any exception, then keep going.
            // will be used only at the 1st login since homeLoginButton is available
            homePage.homeLoginButton.click();
        }catch (Exception e){
        }

//        GOING TO THE LOGIN PAGE AFTER FIRST TIME
        try{
            // if there is any exception, then keep going.
            // will be used AFTER the 1st login since userID is available AFTER the 1st login
//            Logging Out
            ReusableMethods.waitFor(1);
            homePage.userID.click();
            ReusableMethods.waitFor(1);
            homePage.logoutLink.click();
            ReusableMethods.waitFor(1);
            homePage.OK.click();
            ReusableMethods.waitFor(1);
            homePage.homeLoginButton.click();

        }catch (Exception e){

        }
    }

    @Given("user tries to login as {string}")
    public void user_tries_to_login_as(String string) throws IOException {

//        path of customer sheet
        String path = "./src/test/resources/testdata/mysmoketestdata.xlsx";
//        customer sheet name
        String customerSheet ="admin_info";
//        Use Excel Util
        excelUtil = new ExcelUtil(path,customerSheet);
//        getting the data from the excel using excel util method
        testData=excelUtil.getDataList();
        System.out.println(testData);
        for (Map<String ,String> eachData: testData){
            login();
//            Not that we are on login page, we can send username, password, and click on login button
            ReusableMethods.waitFor(1);
            loginPage.username.sendKeys(eachData.get("address"));
            ReusableMethods.waitFor(1);
            loginPage.password.sendKeys(eachData.get("password").substring(0,5));
            ReusableMethods.waitFor(1);
            loginPage.loginButton.click();
            ReusableMethods.waitFor(1);
//            Asserting making sure login is successful
            Assert.assertTrue(homePage.userID.isDisplayed());
            ReusableMethods.getScreenshot(eachData.get("username"));
        }

    }

}
