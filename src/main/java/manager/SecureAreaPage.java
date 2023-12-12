package manager;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class SecureAreaPage {
   protected WebDriver webDriver;
   private By messageFromSecureArea = By.xpath("//*[@id='flash']");
   private By logoutButton = By.xpath("//*[@id='content']/div/a/i");

    /*public SecureAreaPage(WebDriver webDriver){
        this.webDriver = webDriver;
        if(this.messageFromSecureArea.equals("You logged into a secure area!\n×")){
            throw new IllegalStateException("This is not a Secure Area  page," + "current page is>" + webDriver.getCurrentUrl());
        }
    }*/
    public SelenideElement getMessageText(){
        return $(messageFromSecureArea);
    }
    public LoginPage logOut(){
        $(logoutButton).click();
        return page(LoginPage.class);
    }
    /*public LoginPage logout(){
        *//*HomePage homePage = new HomePage(webDriver);
        LoginPage loginPage = homePage.openLoginPage();
        loginPage.typeCorrectUserName();
        loginPage.typeCorrectPassword();
        loginPage.submitLoginData();*//*
        WebElement element = webDriver.findElement(logoutButton);
        element.click();
        return new LoginPage(webDriver);
    }*/

}
