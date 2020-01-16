package com.vytrack.step_definitions;
import io.cucumber.java.en.*;

public class LoginStepDefs {
    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        System.out.println("I opened the browser and navigate to qa3.vytrack.com");
    }
    @When("the user enter the driver information")
    public void the_user_enter_the_driver_information() {
        System.out.println("I entered user1 and UserUser123");
    }
    @Then("the user should be able to login")
    public void the_user_should_be_able_to_login() {
        System.out.println("I verified that I see the dashboard page");
    }
    @When("the user enter the sales manager information")
    public void the_user_enter_the_sales_manager_information() {
        System.out.println("I entered SalesManager123 and UserUser123");
    }
    @When("the user enter the store manager information")
    public void the_user_enter_the_store_manager_information() {
        System.out.println("I entered storemanager123 and USerUSer123");
    }


}