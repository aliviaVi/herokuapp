package org.home.login;

import manager.HomePage;
import manager.LoginPage;
import manager.SecureAreaPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PageInputs;

public class SecureAreaLogoutTest  extends TestBase{

    public LoginPage mainStepsToLogin(){
        HomePage homePage = new HomePage(webDriver);
        LoginPage loginPage = homePage.openLoginPage();
        return loginPage;
    }
    @Test
    public void logOut(){
        LoginPage loginPage = mainStepsToLogin();

        loginPage.typeUserName(PageInputs.USER_NAME);
        loginPage.typePassword(PageInputs.PASSWORD);
        SecureAreaPage secureAreaPage =  loginPage.submitLoginData();
        secureAreaPage.logout();

        Assert.assertEquals(secureAreaPage.getMessageText(),"You logged out of the secure area!\n×");
    }
}
