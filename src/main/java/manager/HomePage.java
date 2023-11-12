package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    protected WebDriver webDriver;

    private By authByXpath = By.xpath("//a[contains(text(),'Form Authentication')]");



    public HomePage (WebDriver webDriver){
        this.webDriver =webDriver;
        if(!webDriver.getTitle().equals("The Internet")){
            throw new IllegalStateException("This is not home page," + "current page is>" + webDriver.getCurrentUrl());
        }
    }

    public LoginPage openLoginPage(){
        WebElement element = (new WebDriverWait(webDriver,10))
                .until(ExpectedConditions.presenceOfElementLocated(authByXpath));
        element.click();
        return new LoginPage (webDriver);
    }
    public String getMessage(){
        String text = webDriver.findElement(By.xpath("//*[@id='content']/div/h2")).getText();
        return text;

    }
}
