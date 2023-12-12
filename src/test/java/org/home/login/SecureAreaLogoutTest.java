package org.home.login;

import manager.HomePage;
import manager.LoginPage;
import manager.SecureAreaPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PageInputs;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

public class SecureAreaLogoutTest{

    @Test
    public void logOut(){
        LoginPage loginPage = open(PageInputs.PAGE_URL + "/login", LoginPage.class);
        loginPage.typeUserName(PageInputs.USER_NAME);
        loginPage.typePassword(PageInputs.PASSWORD);
        SecureAreaPage secureAreaPage = loginPage.submitLoginData();
        secureAreaPage.logOut();
        secureAreaPage.getMessageText().shouldHave(text("You logged out of the secure area!\n×"));
    }
}
