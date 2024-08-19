package com.test;

import com.Utilities.Base;
import com.config.Configuration;
import com.pagemanager.PageManager;
import org.openqa.selenium.WebElement;

public class LoginTest extends Base {

    PageManager pagemanager = new PageManager();

    public void launchApplication(String browserName){
        driverLaunch(browserName);
        driver.get(Configuration.appUrl);
        maximize();



    }

    public void loginCredential(String email,String password){

        explicitWaitUntil(pagemanager.getLoginPage().getEmail(),10);

        type(pagemanager.getLoginPage().getEmail(),email);
        type(pagemanager.getLoginPage().getPassword(),password);
        click(pagemanager.getLoginPage().getSigninBtn());


    }


}
