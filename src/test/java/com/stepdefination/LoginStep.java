package com.stepdefination;

import com.Utilities.Base;
import com.pagemanager.PageManager;
import com.test.LoginTest;
import io.cucumber.java.en.*;

public class LoginStep extends Base {
    PageManager pagemanager = new PageManager();
//LoginTest loginTest = new LoginTest();

    @When("login with valid Credential {string} and {string}")
    public void login_with_valid_credential_and(String email, String password) throws InterruptedException {
       Thread.sleep(3000);
        pagemanager.getLoginPage().loginCredential(email,password);
    }
    @Then("Verify the success msg {string}")
    public void verify_the_success_msg(String string) {

    }
    @Then("It should redirect to the dashboard page")
    public void it_should_redirect_to_the_dashboard_page() {

    }
}
