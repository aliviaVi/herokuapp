package org.home.login;

import manager.HomePage;
import manager.LoginPage;
import manager.SecureAreaPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SecureAreaLogoutTest  extends TestBase{

    public LoginPage mainStepsToLogin(){
        HomePage homePage = new HomePage(webDriver);
        LoginPage loginPage = homePage.openLoginPage();
        return loginPage;
    }
    @Test
    public void logOut(){
        LoginPage loginPage = mainStepsToLogin();

        loginPage.typeCorrectUserName();
        loginPage.typeCorrectPassword();
        SecureAreaPage secureAreaPage =  loginPage.submitLoginData();
        secureAreaPage.logout();

        Assert.assertEquals(secureAreaPage.getMessageText(),"You logged out of the secure area!\n×");
    }
}
