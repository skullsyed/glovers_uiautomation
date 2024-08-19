package com.pages;

import com.Utilities.Base;
import com.config.Configuration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Base {

    public LoginPage(){

        if (driver == null) {
            throw new IllegalStateException("Driver is not initialized. Please call driverLaunch() first.");
        }
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "input[id=':R35puuuja:-form-item']")
    private WebElement email;

    @FindBy(css = "input[id=':R55puuuja:-form-item']")
    private WebElement password;

    @FindBy(css = "button[type='submit']")
    private WebElement signinBtn;

    @FindBy(css = "input[id=':R35puuuja:-form-item']")
    private WebElement emailPlaceHolder;

    @FindBy(css = "input[id=':R55puuuja:-form-item']")
    private WebElement passwordPlaceHolder;

    @FindBy(css = "label[for=':R35puuuja:-form-item']")
    private WebElement emailLabel;

    @FindBy(css = "label[for=':R55puuuja:-form-item']")
    private WebElement passwordLabel;

    @FindBy(xpath = "//h1[text()='Sign in']")
    private WebElement signInTitle;

    @FindBy(xpath = "//span[text()='Forgot your password?']")
    private WebElement forgetPassword;


    public WebElement getEmail() {
        return email;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getSigninBtn() {
        return signinBtn;
    }

    public WebElement getEmailPlaceHolder() {
        return emailPlaceHolder;
    }

    public WebElement getPasswordPlaceHolder() {
        return passwordPlaceHolder;
    }

    public WebElement getEmailLabel() {
        return emailLabel;
    }

    public WebElement getPasswordLabel() {
        return passwordLabel;
    }

    public WebElement getSignInTitle() {
        return signInTitle;
    }

    public WebElement getForgetPassword() {
        return forgetPassword;
    }

    public void launchApplication(){

        driver.get(Configuration.appUrl);
        maximize();



    }

    public void loginCredential(String emailId,String password){

        if(getEmail()!=null){

            explicitWaitUntil(getEmail(),10);
        }else{
            System.out.println("Cannot access the element");
        }

        type(getEmail(),emailId);
        type(getPassword(),password);
        click(getSigninBtn());


    }
}
