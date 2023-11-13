package org.home.login;

import manager.HomePage;
import manager.LoginPage;
import manager.SecureAreaPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {


    public LoginPage mainStepsToLogin(){
        HomePage homePage = new HomePage(webDriver);
        LoginPage loginPage = homePage.openLoginPage();
        return loginPage;
    }


    @Test
    public void loginSuccessTest(){
        LoginPage loginPage = mainStepsToLogin();
      loginPage.typeCorrectUserName();
      loginPage.typeCorrectPassword();
     SecureAreaPage secureAreaPage =  loginPage.submitLoginData();

     Assert.assertEquals(secureAreaPage.getMessageText(),"You logged into a secure area!\n×");
    }


    @Test
    public void loginIncorrectUserName(){
        LoginPage loginPage = mainStepsToLogin();
        loginPage.typeIncorrectUserName();
        loginPage.typeCorrectPassword();
        SecureAreaPage secureAreaPage = loginPage.submitLoginData();

        Assert.assertEquals(secureAreaPage.getMessageText(), "Your username is invalid!\n×");
    }

    @Test
    public void loginIncorrectPassword(){
        LoginPage loginPage = mainStepsToLogin();
        loginPage.typeCorrectUserName();
        loginPage.typeIncorrectPassword();
        SecureAreaPage secureAreaPage = loginPage.submitLoginData();

        Assert.assertEquals(secureAreaPage.getMessageText(), "Your password is invalid!\n×");
    }

}
