package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class HoversPage {

    protected WebDriver webDriver;

    private By userAvatarXPath = By.xpath("//*[@id='content']/div/div[1]");
   // private By avatarText = By.xpath("//*[@id='content']/div/div[1]/div");
    private By userAvatar = By.tagName("img");
    private By avatarText = By.tagName("h5");
    private By hoversTextOnThePage = By.xpath("//*[@id='content']/div/h3"); 


    public HoversPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        if (!webDriver.findElement(hoversTextOnThePage).getText().equals("Hovers")) {
            throw new IllegalStateException("This is not a Hovers page," + "current page is>" + webDriver.getCurrentUrl());
        }
    }
    
    public void hoverOfAvatarPicture(int i){
        Actions actions = new Actions(webDriver);
        List<WebElement> elements = webDriver.findElements(userAvatar);
        actions.moveToElement(elements.get(i)).click().perform();

    }

    public void clickOfPicture(){
        Actions actions = new Actions(webDriver);
        WebElement element = webDriver.findElement(userAvatarXPath);
        actions.moveToElement(element).click();
      //  actions.perform();
    }
    
    public String getTextAvatar(){
       return webDriver.findElement(avatarText).getText();
    }
}
