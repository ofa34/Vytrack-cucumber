package com.vytrack.step_definitions;
import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class LoginStepDefs {
    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        System.out.println("Opening the login page");
        //Driver.get()-->this gets webdriver
        //driver == Driver.get()
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
    }
    @When("the user enter the driver information")
    public void the_user_enter_the_driver_information() throws InterruptedException{
        LoginPage loginPage=new LoginPage();
        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");
        loginPage.login(username,password);
    }
    @Then("the user should be able to login")
    public void the_user_should_be_able_to_login() throws InterruptedException{
        BrowserUtils.waitFor(2);
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals("Dashboard",actualTitle);
    }
    @When("the user enter the sales manager information")
    public void the_user_enter_the_sales_manager_information() {
        System.out.println("I entered SalesManager123 and UserUser123");
        LoginPage loginPage=new LoginPage();
        String username = ConfigurationReader.get("sales_manager_username");
        String password = ConfigurationReader.get("sales_manager_password");
        loginPage.login(username,password);
    }
    @When("the user enter the store manager information")
    public void the_user_enter_the_store_manager_information() {

        LoginPage loginPage=new LoginPage();
        String username = ConfigurationReader.get("store_manager_username");
        String password = ConfigurationReader.get("store_manager_password");
        loginPage.login(username,password);
    }


}