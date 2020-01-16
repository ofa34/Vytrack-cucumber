package com.vytrack.step_definitions;

import io.cucumber.java.en.*;

public class NavigationMenuStepDefs {
    @Given("the user is on the dashboard page")
    public void the_user_is_on_the_dashboard_page() {
        System.out.println("1");
    }

    @When("the user navigate to Fleet then Vehicles option")
    public void the_user_navigate_to_Fleet_then_Vehicles_option() {
        System.out.println("2");
    }

    @Then("the expected url should be https:\\/\\/qa{int}.vytrack.com\\/entity\\/fleet")
    public void the_expected_url_should_be_https_qa_vytrack_com_entity_fleet(Integer int1) {
        System.out.println("3");
    }
    @When("the user navigate to Marketing then Campaigns option")
    public void the_user_navigate_to_Marketing_then_Campaigns_option() {
        System.out.println("4");
    }

    @Then("the expected url should be https:\\/\\/qa{int}.vytrack.com\\/campaign\\/")
    public void the_expected_url_should_be_https_qa_vytrack_com_campaign(Integer int1) {
        System.out.println("5");
    }

    @When("the user navigate to Activities then Calendar Events option")
    public void the_user_navigate_to_Activities_then_Calendar_Events_option() {
        System.out.println("5");
    }

    @Then("the expected url should be https:\\/\\/qa{int}.vytrack.com\\/calendar\\/event")
    public void the_expected_url_should_be_https_qa_vytrack_com_calendar_event(Integer int1) {
        System.out.println("6");
    }
}
