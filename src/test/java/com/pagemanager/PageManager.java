package com.pagemanager;

import com.Utilities.Base;
import com.pages.LoginPage;
import com.test.LoginTest;

public class PageManager extends Base {

   private LoginPage loginPage;
   private LoginTest loginTest;

    public LoginPage getLoginPage() {
        return (loginPage==null)?loginPage = new LoginPage():loginPage;
    }

    public LoginTest getLoginTest(){
        return  (loginTest==null)?loginTest = new LoginTest():loginTest;
    }

}
