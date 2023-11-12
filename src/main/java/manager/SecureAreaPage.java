package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SecureAreaPage {
   protected WebDriver webDriver;
   private By messageFromSecureArea = By.xpath("//*[@id='flash']");
   private By logoutButton = By.xpath("//*[@id='content']/div/a/i");

    public SecureAreaPage(WebDriver webDriver){
        this.webDriver = webDriver;
        if(this.messageFromSecureArea.equals("You logged into a secure area!\n×")){
            throw new IllegalStateException("This is not a Secure Area  page," + "current page is>" + webDriver.getCurrentUrl());
        }
    }
    public String getMessageText(){
        return webDriver.findElement(messageFromSecureArea).getText();
    }
    public LoginPage logout(){
        /*HomePage homePage = new HomePage(webDriver);
        LoginPage loginPage = homePage.openLoginPage();
        loginPage.typeCorrectUserName();
        loginPage.typeCorrectPassword();
        loginPage.submitLoginData();*/
        WebElement element = webDriver.findElement(logoutButton);
        element.click();
        return new LoginPage(webDriver);
    }

}
