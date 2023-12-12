package org.home.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import utils.PageInputs;

import java.util.concurrent.TimeUnit;

public class TestBase {

   public  WebDriver webDriver;

    @BeforeMethod
    public void setUp(){
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.get(PageInputs.PAGE_URL);
    }
    @AfterSuite
    public void tearDown(){
        webDriver.quit();
    }




}
