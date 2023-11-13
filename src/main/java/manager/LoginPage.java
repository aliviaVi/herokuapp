package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    protected WebDriver webDriver;

    private By userNameById = By.id("username");
    private String name = "tomsmith";

    private String incorrectUserName = "tomsmith123";
    private String password = "SuperSecretPassword!";
    private String incorrectPass = "SuperSecretPassword!123";
    private By passwordById = By.id("password");
    private By loginButtonByXpath = By.xpath("//form[@id='login']/button/i");
    private By loginPageByXpath = By.xpath("//*[@id='content']/div/h2");


    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        if (!webDriver.findElement(By.xpath("//*[@id='content']/div/h2")).getText().equals("Login Page")) {
            throw new IllegalStateException("This is not a Login page," + "current page is>" + webDriver.getCurrentUrl());
        }
    }

    public void typeCorrectUserName() {
        WebElement element = webDriver.findElement(userNameById);
        element.click();
        element.clear();
        element.sendKeys(name);
    }

    public void typeCorrectPassword() {
        WebElement element = webDriver.findElement(passwordById);
        element.click();
        element.clear();
        element.sendKeys(password);
    }

    public void typeIncorrectPassword() {
        WebElement element = webDriver.findElement(passwordById);
        element.click();
        element.clear();
        element.sendKeys(incorrectPass);
    }

    public void typeIncorrectUserName() {
        WebElement element = webDriver.findElement(userNameById);
        element.click();
        element.clear();
        element.sendKeys(incorrectUserName);
    }

public  SecureAreaPage submitLoginData(){
        WebElement element = webDriver.findElement(loginButtonByXpath);
        element.click();
        return new SecureAreaPage(webDriver);

}
}
