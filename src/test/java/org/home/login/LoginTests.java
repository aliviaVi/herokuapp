package org.home.login;


import manager.LoginPage;
import manager.SecureAreaPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.PageInputs;

import static com.codeborne.selenide.Condition.text;


public class LoginTests {
      LoginPage loginPage = new LoginPage();


      @BeforeMethod
      public void open(){
          loginPage.openPage();
      }
    @Test
    public void loginSuccessTest(){
        loginPage.typeUserName(PageInputs.USER_NAME);
        loginPage.typePassword(PageInputs.PASSWORD);
        SecureAreaPage secureAreaPage =  loginPage.submitLoginData();
        secureAreaPage.getMessageText().shouldHave(text("You logged into a secure area!\n×"));

    }
    @Test
    public void LoginWithIncorrectUserName(){
        loginPage.typeUserName(PageInputs.INCORRECT_USER_NAME);
        loginPage.typePassword(PageInputs.INCORRECT_PASSWORD);
        SecureAreaPage secureAreaPage = loginPage.submitLoginData();
        secureAreaPage.getMessageText().shouldHave(text("Your username is invalid!\n×"));
    }
    @Test
    public void loginWithIncorrectPassword(){
        loginPage.typeUserName(PageInputs.USER_NAME);
        loginPage.typePassword(PageInputs.INCORRECT_PASSWORD);
        SecureAreaPage secureAreaPage = loginPage.submitLoginData();
        secureAreaPage.getMessageText().shouldHave(text("Your password is invalid!\n×"));
    }

}
