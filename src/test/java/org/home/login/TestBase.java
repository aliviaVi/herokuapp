package org.home.login;

import manager.LoginPageManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

import static java.time.Duration.*;

public class TestBase {
    public LoginPageManager loginPageManager;
    WebDriver webDriver = new ChromeDriver();

    @BeforeMethod
    public void setUp(){
        loginPageManager.init();
       // webDriver.get("http://the-internet.herokuapp.com");
    }


    @AfterSuite
    public void tearDown(){
       // loginPageManager.tearDown();
        webDriver.quit();
    }
}
