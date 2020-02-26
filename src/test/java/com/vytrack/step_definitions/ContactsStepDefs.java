package com.vytrack.step_definitions;

import com.vytrack.pages.ContactInfoPage;
import com.vytrack.pages.ContactsPage;
import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.DBUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ContactsStepDefs {
    @Then("the user should see following menu options")
    public void the_user_should_see_following_menu_options(List<String> menuOptions) {
        System.out.println("menuOptions.size() = " + menuOptions.size());
        System.out.println("Menu options: " + menuOptions);
        BrowserUtils.waitFor(2);

        DashboardPage dashboardPage = new DashboardPage();
        List<String> actualMenuOptions = BrowserUtils.getElementsText(dashboardPage.menuOptions);
        System.out.println(actualMenuOptions);

        assertEquals(menuOptions,actualMenuOptions);
    }
    @When("the use logs in using following credentials")
    public void the_use_logs_in_using_following_credentials(Map<String,String> userData) {
        new LoginPage().login(userData.get("username"),userData.get("password"));
        //verify fullname on the top right corner from website with firstname,lastname from map
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.waitUntilLoaderScreenDisappear();
        String actualFullname = dashboardPage.getUserName();
        String expectedFullname= userData.get("firstname")+" "+userData.get("lastname");
        assertEquals(expectedFullname,actualFullname);

    }
    @When("the user click {string} from contacts")
    public void the_user_click_from_contacts(String email) {


        //click the row with the email
        ContactsPage contactsPage = new ContactsPage();
        contactsPage.waitUntilLoaderScreenDisappear();
        contactsPage.getContactEmail(email).click();
    }

    @Then("the information should be the same with database")
    public void the_information_should_be_the_same_with_database() {
        BrowserUtils.waitFor(3);
        //getting information from UI-GUI-Front-End-Browser
        ContactInfoPage contactInfoPage = new ContactInfoPage();
        String actualFullname = contactInfoPage.contactFullName.getText();
        String actualEmail = contactInfoPage.email.getText();
        String actualPhone = contactInfoPage.phone.getText();
        System.out.println("actualFullname = " + actualFullname);
        System.out.println("actualEmail = " + actualEmail);
        System.out.println("actualPhone = " + actualPhone);

        //get information from database

        String query = "select concat(name_prefix,' ', first_name,' ',last_name) as \"fullname\", e.email,p.phone\n" +
                "from orocrm_contact c JOIN orocrm_contact_email e\n" +
                "on c.id = e.owner_id\n" +
                "join orocrm_contact_phone p\n" +
                "on e.owner_id = p.owner_id\n" +
                "where e.email = 'mbrackstone9@example.com';";
        Map<String, Object> rowMap = DBUtils.getRowMap(query);
        System.out.println("rowMap = " + rowMap);

        //compare UI to Database
        String expectedFullname = (String) rowMap.get("fullname");
        String expectedEmail = (String) rowMap.get("email");
        String expectedPhone = (String) rowMap.get("phone");

        System.out.println("expectedFullname = " + expectedFullname);
        System.out.println("expectedEmail = " + expectedEmail);
        System.out.println("expectedPhone = " + expectedPhone);

        //compare UI to Database
        assertEquals(expectedFullname,actualFullname);
        assertEquals(expectedEmail,actualEmail);
        assertEquals(expectedPhone,actualPhone);

    }
    @Then("the information {string} should be the same with database")
    public void the_information_should_be_the_same_with_database(String email) {

            //getting information from UI-GUI-Front-End-Browser
            ContactInfoPage contactInfoPage = new ContactInfoPage();
            String actualFullname = contactInfoPage.contactFullName.getText();
            String actualEmail = contactInfoPage.email.getText();
            String actualPhone = contactInfoPage.phone.getText();
            System.out.println("actualFullname = " + actualFullname);
            System.out.println("actualEmail = " + actualEmail);
            System.out.println("actualPhone = " + actualPhone);
            //getting information from database
            String query = "select concat(name_prefix,' ',first_name,' ',last_name) as fullname, e.email, phone\n" +
                    "from orocrm_contact crm JOIN orocrm_contact_email e\n" +
                    "on crm.id = e.owner_id\n" +
                    "join orocrm_contact_phone p\n" +
                    "on e.owner_id = p.owner_id\n" +
                    "where e.email = '"+email+"';";
            System.out.println("query = " + query);
            Map<String, Object> rowMap = DBUtils.getRowMap(query);
            String expectedFullname = (String) rowMap.get("fullname");
            String expectedEmail = (String) rowMap.get("email");
            String expectedPhone = (String) rowMap.get("phone");
            System.out.println("expectedFullname = " + expectedFullname);
            System.out.println("expectedEmail = " + expectedEmail);
            System.out.println("expectedPhone = " + expectedPhone);
            //compare UI to Database
            assertEquals(expectedFullname,actualFullname);
            assertEquals(expectedEmail,actualEmail);
            assertEquals(expectedPhone,actualPhone);
        }

    }
