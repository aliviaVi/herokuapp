package manager;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.PageInputs;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    private By userNameById = By.id("username");

    private By passwordById = By.id("password");
    private By loginButtonByXpath = By.xpath("//form[@id='login']/button/i");
    private By loginPageByXpath = By.xpath("//*[@id='content']/div/h2");


    public void typeUserName(String userName) {
         $(userNameById).setValue(userName);
    }

    public void typePassword(String password) {
        $(passwordById).setValue(password);
    }


    public  SecureAreaPage submitLoginData(){
         $(loginButtonByXpath).click();
        return page(SecureAreaPage.class);

}
    public LoginPage openPage(){
        LoginPage loginPage = open(PageInputs.PAGE_URL + "/login", LoginPage.class);
        return loginPage;
    }
}
