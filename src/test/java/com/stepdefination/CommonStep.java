package com.stepdefination;

import com.Utilities.Base;
import com.pagemanager.PageManager;
import io.cucumber.java.en.Given;

public class CommonStep extends Base {
    PageManager pagemanager = new PageManager();
    @Given("launch the application")
    public void launch_the_application() {
        driverLaunch("Chrome");
        pagemanager.getLoginPage().launchApplication();
    }

}
