package org.home.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {


    String name = "tomsmith";
    String password = "SuperSecretPassword!";


    @Test
    public void openPage() {
         loginPageManager.init();

        System.out.println("!!!test passed");

    }
    @Test
    public void LoginSuccessTest () {
        // loginPageManager.init();
        // loginPageManager.openLoginPage();
        // loginPageManager.typeUserName(name);
        // loginPageManager.typeLoginPassword(password);
        // loginPageManager.submit();
        webDriver.findElement(By.xpath("//a[contains(text(),'Form Authentication')]")).click();
        WebElement element = webDriver.findElement(By.id("username"));
        element.click();
        element.clear();
        element.sendKeys("tomsmith");

        WebElement elementPas = webDriver.findElement(By.id("password"));
        elementPas.click();
        elementPas.clear();
        elementPas.sendKeys("SuperSecretPassword!");

        WebElement buttonSubmit = webDriver.findElement(By.xpath("//form[@id='login']/button/i"));
        buttonSubmit.click();

        //   Assert.assertEquals(webDriver.findElement(By.xpath("//*[@id='content']/div/a/i")).getText(),"Logout");
        Assert.assertEquals(webDriver.findElement(By.xpath("//div[@id='flash']")).getText(), "You logged into a secure area!\n×");


    }

    @Test
    public void loginWithIncorrectUsernameTest () {
        webDriver.findElement(By.xpath("//a[contains(text(),'Form Authentication')]")).click();
        WebElement element = webDriver.findElement(By.id("username"));
        element.click();
        element.clear();
        element.sendKeys("tomsmith123");

        WebElement elementPas = webDriver.findElement(By.id("password"));
        elementPas.click();
        elementPas.clear();
        elementPas.sendKeys("SuperSecretPassword!");

        WebElement buttonSubmit = webDriver.findElement(By.xpath("//form[@id='login']/button/i"));
        buttonSubmit.click();

        Assert.assertEquals(webDriver.findElement(By.xpath("//div[@id='flash']")).getText(), "Your username is invalid!\n×");
    }


    @Test
    public void loginWithIncorrectPassTest (){
        webDriver.findElement(By.xpath("//a[contains(text(),'Form Authentication')]")).click();
        WebElement element = webDriver.findElement(By.id("username"));
        element.click();
        element.clear();
        element.sendKeys("tomsmith");

        WebElement elementPas = webDriver.findElement(By.id("password"));
        elementPas.click();
        elementPas.clear();
        elementPas.sendKeys("SuperSecretPassword!123");

        WebElement buttonSubmit = webDriver.findElement(By.xpath("//form[@id='login']/button/i"));
        buttonSubmit.click();

        Assert.assertEquals(webDriver.findElement(By.xpath("//div[@id='flash']")).getText(), "Your password is invalid!\n×");

    }
    @Test
    public void logoutTest (){
        webDriver.findElement(By.xpath("//a[contains(text(),'Form Authentication')]")).click();
        WebElement element = webDriver.findElement(By.id("username"));
        element.click();
        element.clear();
        element.sendKeys("tomsmith");

        WebElement elementPas = webDriver.findElement(By.id("password"));
        elementPas.click();
        elementPas.clear();
        elementPas.sendKeys("SuperSecretPassword!");

        WebElement buttonSubmit = webDriver.findElement(By.xpath("//form[@id='login']/button/i"));
        buttonSubmit.click();
        WebElement logoutButton = webDriver.findElement(By.xpath("//*[@id='content']/div/a/i"));
        logoutButton.click();

        Assert.assertEquals(webDriver.findElement(By.xpath("//*[@id='content']/div/h2")).getText(), "Login Page");
    }
}

