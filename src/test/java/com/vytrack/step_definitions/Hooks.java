package com.vytrack.step_definitions;

import com.vytrack.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setUp(){
        System.out.println("\tthis is coming from BEFORE");
    }
    @After
    public void tearDown(){
        System.out.println("\tthis is coming from AFTER\n");
    }
    @After("@db")
    public void tearDownDatabase(){
        System.out.println("\tCLOSING DATABASE CONNECTION");
    }
    @Before("@db")
    public void setUpDatabase(){
        System.out.println("\tCONNECTION DATABASE");
    }
    @After
    public void teardown(){
        Driver.closeDriver();
    }
}
