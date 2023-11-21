package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    protected WebDriver webDriver;

    private By userNameById = By.id("username");

    private By passwordById = By.id("password");
    private By loginButtonByXpath = By.xpath("//form[@id='login']/button/i");
    private By loginPageByXpath = By.xpath("//*[@id='content']/div/h2");


    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        if (!webDriver.findElement(loginPageByXpath).getText().equals("Login Page")) {
            throw new IllegalStateException("This is not a Login page," + "current page is>" + webDriver.getCurrentUrl());
        }
    }

    public void typeUserName(String userName) {
        WebElement element = webDriver.findElement(userNameById);
              element.sendKeys(userName);
    }

    public void typePassword(String password) {
        WebElement element = webDriver.findElement(passwordById);
        element.sendKeys(password);
    }


public  SecureAreaPage submitLoginData(){
        WebElement element = webDriver.findElement(loginButtonByXpath);
        element.click();
        return new SecureAreaPage(webDriver);

}
}
