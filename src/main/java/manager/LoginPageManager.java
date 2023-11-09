package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static java.time.Duration.ofSeconds;

public class LoginPageManager {
    WebDriver webDriver = new ChromeDriver();



    public void init (){
      this.webDriver.manage().window().maximize();
        this.webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        this.webDriver.get("http://the-internet.herokuapp.com");
       // webDriver.get("http://www.google.com");
    }

    public void tearDown (){
        webDriver.quit();
    }

    public void openLoginPage(){
        webDriver.findElement(By.xpath("//a[contains(text(),'Form Authentication')]")).click();

    }

    public void typeUserName(String userName){
        WebElement element = webDriver.findElement(By.id("username"));
        element.click();
        element.clear();
        element.sendKeys(userName);
    }

    public void typeLoginPassword ( String password){
        WebElement element = webDriver.findElement(By.id("password"));
        element.click();
        element.clear();
        element.sendKeys(password);
    }

    public void submit(){
        WebElement buttonSubmit = webDriver.findElement(By.xpath("//form[@id='login']/button/i"));
        buttonSubmit.click();
    }

    public String getMassage(){
        return webDriver.findElement(By.id("flash")).getText();
    }
}
